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

    public static final String QUEUE = "direct-queue-lazy";

    public static final String EXCHANGE = "exchange-direct";

    public static final String ROUTING_KEY = "direct.queue.lazy";

    @Bean
    Queue lazyQueue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-queue-mode", "lazy");
        return new Queue(QUEUE, false, false, false, args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding lazyQueueBinding(Queue lazyQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(lazyQueue).to(directExchange).with(ROUTING_KEY);
    }

}
