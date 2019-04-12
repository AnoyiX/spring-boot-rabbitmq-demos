package com.anoyi.exchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic exchange
 * 发送到该交换器的消息都会被路由到与 routing key 匹配的队列中
 * 说明：
 * routing key 以 '.' 分隔为多个单词
 * routing key 以 '*' 匹配一个单词
 * routing key 以 '#' 匹配零个或多个单词
 * 例如：
 * queue.topic.key ->  QUEUE_1 + QUEUE_2
 * test.topic.key -> QUEUE_1
 * queue -> QUEUE_2
 * queue.topic -> QUEUE_2
 */
@Configuration
public class TopicExchangeConfig {

    public static final String QUEUE_1 = "topic-queue-1";

    public static final String QUEUE_2 = "topic-queue-2";

    private static final String EXCHANGE = "exchange-topic";

    private static final String ROUTING_KEY_TO_QUEUE1 = "*.topic.*";

    private static final String ROUTING_KEY_TO_QUEUE2 = "queue.#";

    @Bean
    Queue topicQueue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    Queue topicQueue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding bindingTopicQueue1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with(ROUTING_KEY_TO_QUEUE1);
    }

    @Bean
    Binding bindingTopicQueue2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with(ROUTING_KEY_TO_QUEUE2);
    }

}
