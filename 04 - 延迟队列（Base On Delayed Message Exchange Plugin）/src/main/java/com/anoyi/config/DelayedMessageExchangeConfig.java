package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 普通交换器
 */
@Configuration
@Slf4j
public class DelayedMessageExchangeConfig {

    public static final String QUEUE_DELAYED_MESSAGE = "direct-queue-delayed-message";

    public static final String EXCHANGE = "exchange-delayed-message";

    public static final String ROUTING_KEY_DELAYED_MESSAGE = "direct.queue.delayed.message";

    @Bean
    Queue delayedMessageQueue() {
        return new Queue(QUEUE_DELAYED_MESSAGE, false);
    }

    @Bean
    CustomExchange delayedMessageExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(EXCHANGE, "x-delayed-message", false, false, args);
    }

    @Bean
    Binding delayedMessageQueueBinding(Queue delayQueue, CustomExchange delayedMessageExchange) {
        return BindingBuilder.bind(delayQueue).to(delayedMessageExchange).with(ROUTING_KEY_DELAYED_MESSAGE).noargs();
    }

}
