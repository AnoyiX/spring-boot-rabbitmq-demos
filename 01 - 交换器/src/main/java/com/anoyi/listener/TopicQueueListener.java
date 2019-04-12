package com.anoyi.listener;

import com.anoyi.exchange.TopicExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicQueueListener {

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_1)
    public void listenTopicQueue1(String message) {
        log.info("[{}] {}", TopicExchangeConfig.QUEUE_1, message);
    }

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_2)
    public void listenTopicQueue2(String message) {
        log.info("[{}] {}", TopicExchangeConfig.QUEUE_2, message);
    }

}
