package ru.liga.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import ru.liga.orderDto.Dto;
import ru.liga.orderDto.OrderDto;
import ru.liga.orderDto.OrderRequest;
import ru.liga.orderDto.OrderResponse;
import ru.liga.service.api.OrderService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Data
public class OrderServiceImpl implements OrderService {
    private Dto dto = new Dto();

    public OrderServiceImpl(){
        dto = new Dto();
        dto.setOrderDtoList(new ArrayList<>());
    }
    @Override
    public Dto getAllDto() {
        return dto;
    }
    @Override
    public Optional<OrderDto> getDtoById (Integer id) {
        return dto.findById(id);
    }
    @Override
    public OrderResponse makeOrder (OrderRequest request) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(request.getRestaurantId());
        dto.addToList(orderDto);
        return new OrderResponse(1,"","");
    }

}
