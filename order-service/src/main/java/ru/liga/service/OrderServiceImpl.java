package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.liga.dto.Dto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderRequest;
import ru.liga.dto.OrderResponse;
import ru.liga.repository.api.OrderRepository;
import ru.liga.service.api.OrderService;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    
    @Override
    public Dto getAllDto() {
        Dto dto = new Dto();
        //dto.setOrderDtoList(orderRepository.findAll());
        return dto;
    }
    @Override
    public Optional<OrderDto> getDtoById (Integer id) {
        //return orderRepository.findById(id);
        return Optional.empty();
    }
    @Override
    public OrderResponse makeOrder (OrderRequest request) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(request.getRestaurantId());
        //orderRepository.addToList(orderDto);
        //orderRepository.save(orderDto);
        return new OrderResponse(1,"","");
    }



}
