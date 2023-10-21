package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.Order;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.OrderEntity;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public Order getOrderById(Long id) {
        Order order = orderMapper.
                mappEntityToDto(orderRepository.findById(id).orElseThrow());
        return order;
    }

    @Override
    public void setOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }
}
