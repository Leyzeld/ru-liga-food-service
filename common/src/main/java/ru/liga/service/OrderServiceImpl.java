package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.CourierEntity;
import ru.liga.model.OrderEntity;
import ru.liga.repository.CourierRepository;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.OrderService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CourierRepository courierRepository;
    @Override
    public OrderDto getOrderById(UUID id) {
        OrderDto orderDto = orderMapper.
                mappEntityToDto(orderRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("OrderDto с id = %s не найден!", id))));
        return orderDto;
    }

    @Override
    public void setOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> getOrderByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public void setCourier(Long courierId, UUID id) {
        orderRepository.updateCourierEntity(id, courierRepository
                .findById(courierId)
                .orElseThrow(()->new RuntimeException(String.format("CustomerEntity с id = %s не найден!", courierId))));
    }
}
