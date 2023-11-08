package ru.liga;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.liga.controller.KitchenController;
import ru.liga.dto.OrderMessage;
import ru.liga.repository.OrderRepository;
import ru.liga.service.KitchenServiceImpl;
import ru.liga.service.api.RabbitService;
import ru.liga.status.OrderStatus;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@WebMvcTest(KitchenController.class)
@ContextConfiguration(classes = {KitchenServiceApplication.class})
public class KitchenServiceTest {

    @Mock
    private RabbitService rabbitService;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private KitchenServiceImpl kitchenService;

    @Test
    public void testAcceptOrder() {
        // Настройка моков
        UUID id = UUID.randomUUID();
        // Вызов тестируемого метода
        kitchenService.acceptOrder(id);
        // Проверка вызовов методов
        verify(orderRepository, times(1)).updateStatus(eq(id), eq(OrderStatus.ORDER_ACCEPTED.getStatus()));
        verify(rabbitService, times(1)).sendNewOrder(any(OrderMessage.class), eq("kitchenAcceptToNotification"));
    }

    @Test
    public void testDeclineOrder() {
        // Настройка моков
        UUID id = UUID.randomUUID();
        // Вызов тестируемого метода
        kitchenService.declineOrder(id);
        // Проверка вызовов методов
        verify(orderRepository, times(1)).updateStatus(eq(id), eq(OrderStatus.ORDER_DECLINED.getStatus()));
        verify(rabbitService, times(1)).sendNewOrder(any(OrderMessage.class), eq("kitchenDeniedToNotification"));
    }

    @Test
    public void testReadyOrder() {
        // Настройка моков
        UUID id = UUID.randomUUID();
        // Вызов тестируемого метода
        kitchenService.readyOrder(id);
        // Проверка вызовов методов
        verify(orderRepository, times(1)).updateStatus(eq(id), eq(OrderStatus.WAITING_FOR_COURIER.getStatus()));
        verify(rabbitService, times(1)).sendNewOrder(any(OrderMessage.class), eq("kitchenDeniedToNotification"));
    }
}
