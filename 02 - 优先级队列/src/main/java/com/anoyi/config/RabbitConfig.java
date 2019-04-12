package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {

    public static final String NORMAL_QUEUE = "normal-queue";

    public static final String NORMAL_EXCHANGE = "normal-exchange";

    public static final String NORMAL_ROUTING_KEY = "test.normal.queue";


    @Bean
    Queue queue() {
        return new Queue(NORMAL_QUEUE, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(NORMAL_EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(NORMAL_ROUTING_KEY);
    }

}
