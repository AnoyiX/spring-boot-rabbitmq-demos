package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class DirectExchangeConfig {

    public static final String QUEUE = "direct-queue-priority";

    public static final String EXCHANGE = "exchange-direct";

    public static final String ROUTING_KEY = "direct.queue.priority";

    @Bean
    Queue directQueuePriority() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-max-priority", 100);
        return new Queue(QUEUE, false, false, false, args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding directQueuePriorityBinding(Queue directQueuePriority, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueuePriority).to(directExchange).with(ROUTING_KEY);
    }

}
