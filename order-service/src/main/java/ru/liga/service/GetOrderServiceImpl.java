package ru.liga.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.liga.dto.*;;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.*;
import ru.liga.service.api.GetOrderService;

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
public class GetOrderServiceImpl implements GetOrderService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuItemsRepository restaurantMenuItemsRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final RestaurantMapper restaurantMapper;
    private final CustomerRepository customerRepository;



    @Override
    public List<GetOrderResponse> getAllOrders() {
        List<GetOrderResponse> getOrderResponseList = new ArrayList<>();
        List<OrderEntity> all = orderRepository.findAll();
        for(long i = 0; i < all.size(); i++) {
            getOrderResponseList.add(getOrderById(i+1));
        }
        return getOrderResponseList;
    }

    @Override
    public GetOrderResponse getOrderById(Long id) {
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
        getOrderResponse.setId(orderEntity.getId());
        getOrderResponse.setRestaurantDto(restaurantMapper
                .mappEntityToDto(restaurantRepository
                        .findById(orderEntity
                                .getRestaurantEntity()
                                .getRestId())
                        .orElseThrow(()->new RuntimeException(String.format("Restaurant с id = %s не найден!", orderEntity
                                .getRestaurantEntity()
                                .getRestId())))));
        getOrderResponse.setTimestamp(orderEntity.getTimestamp());
        List<OrderItemEntity> all = orderItemRepository.findAll();
        List<Item> Items = new ArrayList<>();
        for(OrderItemEntity iter:all) {
            if(iter.getOrderId().getId().equals(id)) {
                Item newItem = new Item();
                newItem.setQuantity(iter.getQuantity());
                newItem.setPrice(restaurantMenuItemsRepository
                        .findById(iter
                                .getRestaurantMenuItemEntity()
                                .getRestMenuItemId())
                        .get()
                        .getPrice());
                newItem.setDescription(restaurantMenuItemsRepository
                        .findById(iter.getRestaurantMenuItemEntity()
                                .getRestMenuItemId())
                        .get()
                        .getDescription());
                newItem.setImage(restaurantMenuItemsRepository
                        .findById(iter
                                .getRestaurantMenuItemEntity()
                                .getRestMenuItemId())
                        .get()
                        .getImage());
                Items.add(newItem);
            }
        }
        getOrderResponse.setItems(Items);
        return getOrderResponse;
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
        orderEntity.setStatus("Заказ создан и ожидает доставки");
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
