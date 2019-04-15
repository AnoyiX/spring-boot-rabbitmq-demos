package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 备用交换器
 */
@Configuration
@Slf4j
public class AlternateDirectExchangeConfig {

    public static final String QUEUE_ALTERNATE= "direct-queue-alternate";

    public static final String EXCHANGE = "exchange-direct-alternate";

    public static final String ROUTING_KEY_ALTERNATE = "direct.queue.alternate";

    @Bean
    Queue alternateQueue() {
        return new Queue(QUEUE_ALTERNATE, false);
    }

    @Bean
    DirectExchange directAlternateExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding alternateQueueBinding(Queue alternateQueue, DirectExchange directAlternateExchange) {
        return BindingBuilder.bind(alternateQueue).to(directAlternateExchange).with(ROUTING_KEY_ALTERNATE);
    }

}
