package ru.liga.orderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    List<OrderDto> orderDtoList = new ArrayList<>();
    private Integer pageIndex;
    private Integer pageCount;

    public void addToList (OrderDto orderDto) {
        orderDtoList.add(orderDto);
    }
    public OrderDto findById(Integer id) {
        return orderDtoList.stream().
                filter(_odl -> id.equals(_odl.getId())).
                findFirst().orElse(null);
    }
}
