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

    public static final String QUEUE_MAX_LENGTH = "direct-queue-max-length";

    public static final String QUEUE_TTL = "direct-queue-ttl";

    public static final String QUEUE_REJECT = "direct-queue-reject";

    public static final String EXCHANGE = "exchange-direct";

    public static final String ROUTING_KEY_MAX_LENGTH = "direct.queue.max.length";

    public static final String ROUTING_KEY_TTL = "direct.queue.ttl";

    public static final String ROUTING_KEY_REJECT = "direct.queue.reject";

    @Bean
    Queue maxLengthQueue() {
        Map<String, Object> args= new HashMap<>();
        // 设置队列最大长度
        args.put("x-max-length", 10);
        // 设置死信转发的 exchange 和 routing key
        args.put("x-dead-letter-exchange", DeadLetterExchangeConfig.EXCHANGE);
        args.put("x-dead-letter-routing-key", DeadLetterExchangeConfig.ROUTING_KEY_BY_MAX_LENGTH);
        return new Queue(QUEUE_MAX_LENGTH, false, false, false, args);
    }

    @Bean
    Queue ttlQueue() {
        Map<String, Object> args= new HashMap<>();
        // 设置消息存活时间 10s
        args.put("x-message-ttl", 10000);
        // 设置死信转发的 exchange 和 routing key
        args.put("x-dead-letter-exchange", DeadLetterExchangeConfig.EXCHANGE);
        args.put("x-dead-letter-routing-key", DeadLetterExchangeConfig.ROUTING_KEY_BY_TTL);
        return new Queue(QUEUE_TTL, false, false, false, args);
    }

    @Bean
    Queue rejectQueue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-dead-letter-exchange", DeadLetterExchangeConfig.EXCHANGE);
        args.put("x-dead-letter-routing-key", DeadLetterExchangeConfig.ROUTING_KEY_BY_REJECT);
        return new Queue(QUEUE_REJECT, false, false, false, args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding maxLengthQueueBinding(Queue maxLengthQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(maxLengthQueue).to(directExchange).with(ROUTING_KEY_MAX_LENGTH);
    }

    @Bean
    Binding ttlQueueBinding(Queue ttlQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(ttlQueue).to(directExchange).with(ROUTING_KEY_TTL);
    }

    @Bean
    Binding rejectQueueBinding(Queue rejectQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(rejectQueue).to(directExchange).with(ROUTING_KEY_REJECT);
    }

}
