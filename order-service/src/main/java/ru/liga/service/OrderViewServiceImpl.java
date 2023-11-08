package ru.liga.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.dto.*;;
import ru.liga.mapper.OrderMapper;
import ru.liga.dto.OrderMessage;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.*;
import ru.liga.service.api.OrderViewService;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

import java.util.*;
import java.sql.Timestamp;

/**
 * Этот сервис нужен для получения ответа на запрос "GetOrder" чтобы он выглядил как в ТЗ, а не как в БД
 * Чтобы небыло путанницы я назвал его OrderViewService. Так как OrderService уже существует и используется в других задачах
 */
@Service
@Data
@Slf4j
public class OrderViewServiceImpl implements OrderViewService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuItemsRepository restaurantMenuItemsRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;
    private final RabbitService rabbitService;



    @Override
    public List<OrderViewResponse> getAllOrders() {
        List<OrderEntity> all = orderRepository.findAll();
        List<OrderViewResponse> orderViewResponseList = orderMapper.toViewResponseList(all);
        return orderViewResponseList;
    }

    @Override
    public OrderViewResponse getOrderById(UUID id) {
        OrderEntity orderEntity = orderRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException(String.format("OrderEntity с id = %s не найден!", id)));
        return orderMapper.toViewResponse(orderEntity);

    }

    @Override
    @Transactional
    public void addOrder(OrderRequest orderRequest, Long id) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRestaurantEntity(restaurantRepository
                .findById(orderRequest
                        .getRestaurantId())
                .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", orderRequest
                        .getRestaurantId()))));
        orderEntity.setId(UUID.randomUUID());
        orderEntity.setCustomerEntity(customerRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException(String.format("CustomerEntity с id = %s не найден!", id))));
        orderEntity.setStatus(OrderStatus.ORDER_CREATED.getStatus());
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        orderEntity.setTimestamp(timestamp);
        orderRepository.save(orderEntity);

        List<OrderEntity> all = orderRepository.findAll();
        orderEntity.setId(all.get(all.size()-1).getId());
        OrderMessage orderMessage = new OrderMessage(orderEntity.getId(),orderEntity.getStatus());
        rabbitService.sendNewOrder(orderMessage, "newOrderToNotification");

        for (int i = 0; i<orderRequest.getMenuItems().size(); i++) {
            Long restaurantMenuItemId = getRestaurantMenuItemIdInOrderRequest(orderRequest, i);
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrderId(orderEntity);
            orderItemEntity.setRestaurantMenuItemEntity(restaurantMenuItemsRepository
                    .findById(restaurantMenuItemId)
                    .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", restaurantMenuItemId))));
            orderItemEntity.setPrice(restaurantMenuItemsRepository
                    .findById(restaurantMenuItemId)
                    .orElseThrow(()->new RuntimeException(String.format("RestaurantMenuItem с id = %s не найден!", restaurantMenuItemId)))
                    .getPrice());
            orderItemEntity.setQuantity(orderRequest.getMenuItems().get(i).getQuantity());
            orderItemRepository.save(orderItemEntity);
        }
        log.info("Заказ id = {} успешно создан и отправлен в notification-service", orderEntity.getId());
    }

    @Override
    public OrderMessage updateOrderStatusById(OrderMessage orderMessage) {
        orderRepository.updateStatus(orderMessage.getOrderId(),orderMessage.getOrderStatus());
        return orderMessage;
    }

    public Long getRestaurantMenuItemIdInOrderRequest(OrderRequest orderRequest, Integer id) {
        return orderRequest
                .getMenuItems()
                .get(id)
                .getRestaurantMenuItemId();
    }
}
