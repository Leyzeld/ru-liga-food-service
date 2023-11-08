package ru.liga;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.liga.controller.DeliveryController;
import ru.liga.dto.OrderMessage;
import ru.liga.repository.OrderRepository;
import ru.liga.service.DeliveryServiceImpl;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DeliveryController.class)
@ContextConfiguration(classes = {DeliveryServiceApplication.class})
public class DeliveryServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private RabbitService rabbitService;

    @InjectMocks
    private DeliveryServiceImpl deliveryService;

    @Test
    public void testCompleteOrder() {
        // Настройка моков
        UUID id = UUID.randomUUID();

        // Вызов тестируемого метода
        deliveryService.completeOrder(id);

        // Проверка вызовов методов
        verify(orderRepository, times(1)).updateStatus(eq(id), eq(OrderStatus.DELIVERED.getStatus()));
        verify(rabbitService, times(1)).sendDeliveryComplete(any(OrderMessage.class), eq("deliveryCompleteToNotification"));
    }
}
