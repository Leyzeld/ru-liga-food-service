package service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.liga.dto.OrderViewResponse;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.OrderEntity;
import ru.liga.repository.*;
import ru.liga.service.OrderViewServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderViewServiceImplTest {

    @InjectMocks
    private OrderViewServiceImpl orderViewService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderMapper orderMapper;

    @Test
    public void testGetOrderById() {
        Long id = 1L;
        OrderEntity orderEntity = new OrderEntity();

        when(orderRepository.findById(id)).thenReturn(Optional.of(orderEntity));

        OrderViewResponse orderViewResponse = new OrderViewResponse();
        when(orderMapper.toViewResponse(orderEntity)).thenReturn(orderViewResponse);

        OrderViewResponse response = orderViewService.getOrderById(id);

        assertEquals(orderViewResponse, response);
        verify(orderRepository, times(1)).findById(id);
        verify(orderMapper, times(1)).toViewResponse(orderEntity);
    }

    @Test
    public void testGetOrderByIdThrow() {
        Long id = -1L;
        OrderEntity orderEntity = new OrderEntity();

        when(orderRepository.findById(id)).thenReturn(Optional.of(orderEntity));

        OrderViewResponse orderViewResponse = new OrderViewResponse();
        when(orderMapper.toViewResponse(orderEntity)).thenReturn(orderViewResponse);

        OrderViewResponse response = orderViewService.getOrderById(id);

        assertEquals(orderViewResponse, response);
        verify(orderRepository, times(1)).findById(id);
        verify(orderMapper, times(1)).toViewResponse(orderEntity);
    }
}