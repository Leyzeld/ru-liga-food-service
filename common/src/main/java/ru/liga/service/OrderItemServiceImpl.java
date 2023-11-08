package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderItemDto;
import ru.liga.mapper.OrderItemMapper;
import ru.liga.model.OrderEntity;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.OrderItemRepository;
import ru.liga.service.api.OrderItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    @Override
    public OrderItemDto getOrderItemById(Long id) {
        OrderItemDto orderItemDto = orderItemMapper.
                mappEntityToDto(orderItemRepository.
                        findById(id).
                        orElseThrow(()->new RuntimeException(String.format("OrderItemDto с id = %s не найден!", id))));
        return orderItemDto;
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
        return orderItemRepository.findByOrderId(id);
    }
}
