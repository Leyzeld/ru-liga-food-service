package ru.liga.orderDto;

import liquibase.pro.packaged.O;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dto {

    List<OrderDto> orderDtoList;
    private Integer pageIndex;
    private Integer pageCount;

    public void addToList (OrderDto orderDto) {
        orderDtoList.add(orderDto);
    }
    public Optional<OrderDto> findById(Integer id) {
        return Optional.ofNullable(orderDtoList.stream().
                filter(_odl -> id.equals(_odl.getId())).
                findFirst().orElse(null));
    }
}
