package com.anoyi.listener;

import com.anoyi.exchange.DirectExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DirectQueueListener {

    @RabbitListener(queues = DirectExchangeConfig.QUEUE_1)
    public void listenDirectQueue1(String message) {
        log.info("[{}] {}", DirectExchangeConfig.QUEUE_1, message);
    }

    @RabbitListener(queues = DirectExchangeConfig.QUEUE_2)
    public void listenDirectQueue2(String message) {
        log.info("[{}] {}", DirectExchangeConfig.QUEUE_2, message);
    }

}
