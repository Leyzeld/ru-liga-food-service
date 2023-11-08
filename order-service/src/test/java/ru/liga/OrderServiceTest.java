package ru.liga;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.controller.OrderController;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderViewResponse;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.OrderEntity;
import ru.liga.repository.*;
import ru.liga.service.OrderServiceImpl;
import ru.liga.service.api.RabbitService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration(classes = {OrderServiceApplication.class})
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderMapper orderMapper;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testGetAllOrders() {
        // Настройка моков
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());
        // Вызов тестируемого метода
        List<OrderEntity> all = orderRepository.findAll();
        List<OrderViewResponse> result = orderMapper.toViewResponseList(all);
        // Проверка результата
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetOrderById() {
        // Настройка моков
        UUID id = UUID.randomUUID();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id);
        when(orderRepository.findById(id)).thenReturn(Optional.of(orderEntity));
        // Вызов тестируемого метода
        OrderDto result = orderService.getOrderById(id);
        // Проверка результата
        assertNotNull(result);
        assertEquals(id, result.getId());
    }
}
