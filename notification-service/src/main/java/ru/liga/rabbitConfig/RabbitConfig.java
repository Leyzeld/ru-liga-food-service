package ru.liga.rabbitConfig;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.liga.queues.QueueNotifier.*;

@EnableRabbit
@Configuration
public class RabbitConfig {
    @Bean
    public Declarables newOrderToKitchenQueue() {
        Queue OrderToKitchen = new Queue(ORDER_TO_KITCHEN, false);
        Queue kitchenToOrder = new Queue(KITCHEN_TO_ORDER_SERVICE, false);
        Queue orderToDelivery = new Queue(ORDER_TO_DELIVERY, false);
        Queue deliveryToOrder = new Queue(DELIVERY_TO_ORDER, false);

        DirectExchange directExchange = new DirectExchange("directExchange");

        return new Declarables(
                OrderToKitchen, kitchenToOrder, orderToDelivery, deliveryToOrder,
                directExchange,
                BindingBuilder.bind(OrderToKitchen).to(directExchange).with(ORDER_TO_KITCHEN),
                BindingBuilder.bind(kitchenToOrder).to(directExchange).with(KITCHEN_TO_ORDER_SERVICE),
                BindingBuilder.bind(orderToDelivery).to(directExchange).with(ORDER_TO_DELIVERY),
                BindingBuilder.bind(deliveryToOrder).to(directExchange).with(DELIVERY_TO_ORDER)
        );
    }
}