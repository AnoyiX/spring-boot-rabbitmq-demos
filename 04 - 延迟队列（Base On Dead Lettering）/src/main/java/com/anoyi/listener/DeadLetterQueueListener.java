package com.anoyi.listener;

import com.anoyi.config.DeadLetterExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeadLetterQueueListener {

    /**
     * 监听死信队列由于超时产生的消息
     */
    @RabbitListener(queues = DeadLetterExchangeConfig.QUEUE_BY_TTL)
    public void listenTTL(String message) {
        log.info("[{}] {}", DeadLetterExchangeConfig.QUEUE_BY_TTL, message);
    }

}
