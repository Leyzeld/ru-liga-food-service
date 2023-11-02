package ru.liga.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.liga.dto.*;;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.*;
import ru.liga.service.api.OrderViewService;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Этот сервис нужен для получения ответа на запрос "GetOrder" чтобы он выглядил как в ТЗ, а не как в БД
 * Чтобы небыло путанницы я назвал его GetOrderService. Так как OrderService уже существует и используется в других задачах
 */
@Service
@Data
public class OrderViewServiceImpl implements OrderViewService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuItemsRepository restaurantMenuItemsRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;



    @Override
    public List<OrderViewResponse> getAllOrders() {
        List<OrderEntity> all = orderRepository.findAll();
        List<OrderViewResponse> orderViewResponseList = orderMapper.toViewResponseList(all);
        return orderViewResponseList;
    }

    @Override
    public OrderViewResponse getOrderById(Long id) {
        OrderEntity orderEntity = orderRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException(String.format("OrderEntity с id = %s не найден!", id)));
        return orderMapper.toViewResponse(orderEntity);

    }

    @Override
    public void addOrder(OrderRequest orderRequest, Long id) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantEntity(restaurantRepository
                .findById(orderRequest
                        .getRestaurantId())
                .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", orderRequest
                        .getRestaurantId()))));
        orderEntity.setId(orderRepository.count()+1);
        //отправить запрос курьерам на принятие доставки
        //orderEntity.setCourierEntity();
        orderEntity.setCustomerEntity(customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException(String.format("CustomerEntity с id = %s не найден!", id))));
        orderEntity.setStatus("Заказ создан и ожидает курьера");
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        orderEntity.setTimestamp(timestamp);
        orderRepository.save(orderEntity);
        for (int i = 0; i<orderRequest.getMenuItems().size(); i++) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderId(orderEntity);
            orderItemEntity.setRestaurantMenuItemEntity(restaurantMenuItemsRepository
                    .findById(orderRequest
                            .getMenuItems()
                            .get(i)
                            .getRestaurantMenuItemId())
                    .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", id))));
            orderItemEntity.setPrice(restaurantMenuItemsRepository
                    .findById(orderRequest
                            .getMenuItems()
                            .get(i)
                            .getRestaurantMenuItemId())
                    .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", id)))
                    .getPrice());
            orderItemEntity.setQuantity(orderRequest.getMenuItems().get(i).getQuantity());
            orderItemRepository.save(orderItemEntity);
        }
    }
}
