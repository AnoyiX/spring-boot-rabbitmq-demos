package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 普通交换器
 */
@Configuration
@Slf4j
public class DirectExchangeConfig {

    public static final String QUEUE_DELAY = "direct-queue-delay";

    public static final String EXCHANGE = "exchange-direct";

    public static final String ROUTING_KEY_DELAY = "direct.queue.delay";

    @Bean
    Queue delayQueue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-dead-letter-exchange", DeadLetterExchangeConfig.EXCHANGE);
        args.put("x-dead-letter-routing-key", DeadLetterExchangeConfig.ROUTING_KEY_BY_TTL);
        return new Queue(QUEUE_DELAY, false, false, false, args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding delayQueueBinding(Queue delayQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(delayQueue).to(directExchange).with(ROUTING_KEY_DELAY);
    }

}
