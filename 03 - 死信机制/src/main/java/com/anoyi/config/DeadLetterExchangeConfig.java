package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信交换器
 */
@Configuration
@Slf4j
public class DeadLetterExchangeConfig {

    public static final String QUEUE_BY_MAX_LENGTH = "direct-queue-dead-by-max-length";

    public static final String QUEUE_BY_TTL = "direct-queue-dead-by-ttl";

    public static final String QUEUE_BY_REJECT = "direct-queue-dead-by-reject";

    public static final String EXCHANGE = "exchange-direct-dead";

    public static final String ROUTING_KEY_BY_MAX_LENGTH = "direct.queue.dead.max.length";

    public static final String ROUTING_KEY_BY_TTL = "direct.queue.dead.ttl";

    public static final String ROUTING_KEY_BY_REJECT = "direct.queue.dead.reject";

    @Bean
    Queue deadByMaxLengthQueue() {
        return new Queue(QUEUE_BY_MAX_LENGTH, false);
    }

    @Bean
    Queue deadByTTLQueue() {
        return new Queue(QUEUE_BY_TTL, false);
    }

    @Bean
    Queue deadByRejectQueue() {
        return new Queue(QUEUE_BY_REJECT, false);
    }

    @Bean
    DirectExchange deadDirectExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding deadByMaxLengthQueueBinding(Queue deadByMaxLengthQueue, DirectExchange deadDirectExchange) {
        return BindingBuilder.bind(deadByMaxLengthQueue).to(deadDirectExchange).with(ROUTING_KEY_BY_MAX_LENGTH);
    }

    @Bean
    Binding deadByTTLQueueBinding(Queue deadByTTLQueue, DirectExchange deadDirectExchange) {
        return BindingBuilder.bind(deadByTTLQueue).to(deadDirectExchange).with(ROUTING_KEY_BY_TTL);
    }

    @Bean
    Binding deadByRejectQueueBinding(Queue deadByRejectQueue, DirectExchange deadDirectExchange) {
        return BindingBuilder.bind(deadByRejectQueue).to(deadDirectExchange).with(ROUTING_KEY_BY_REJECT);
    }

}
