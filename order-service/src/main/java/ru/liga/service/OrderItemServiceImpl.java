package ru.liga.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.model.OrderItemEntity;
import ru.liga.repository.api.OrderItemRepository;
import ru.liga.service.api.OrderItemService;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemEntity> showAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void addOrderItem(OrderItemEntity orderItemEntity) {
        orderItemRepository.save(orderItemEntity);
    }

    @Override
    public void deleteOrderItemById(Integer id) {
        orderItemRepository.deleteById(id);
    }
}
