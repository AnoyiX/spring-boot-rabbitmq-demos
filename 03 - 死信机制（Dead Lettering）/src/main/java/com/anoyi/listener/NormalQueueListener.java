package com.anoyi.listener;

import com.anoyi.config.DirectExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NormalQueueListener {

    @RabbitListener(queues = DirectExchangeConfig.QUEUE_REJECT)
    public void reject(String message) {
        log.error("[{}] {}", DirectExchangeConfig.QUEUE_REJECT, message);
        throw new AmqpRejectAndDontRequeueException("to dead-letter");
    }

}
