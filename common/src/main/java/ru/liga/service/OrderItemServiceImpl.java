package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderItem;
import ru.liga.mapper.OrderItemMapper;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.OrderItemRepository;
import ru.liga.service.api.OrderItemService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    @Override
    public OrderItem getOrderItemById(Long id) {
        OrderItem orderItem = orderItemMapper.
                mappEntityToDto(orderItemRepository.
                        findById(id).
                        orElseThrow());
        return orderItem;
    }

    @Override
    public void setOrderItem(OrderItemEntity orderItemEntity) {
        orderItemRepository.save(orderItemEntity);
    }

    @Override
    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItemEntity> findOrderItemByOrderId(Long id) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        List<OrderItemEntity> all = orderItemRepository.findAll();
        OrderEntity orderId = all.get(2).getOrderId();
        for(OrderItemEntity iter:all) {
            if(iter.getOrderId().getId().equals(id)) {
                orderItemEntities.add(iter);
            }
        }
        return orderItemEntities;
    }
}
