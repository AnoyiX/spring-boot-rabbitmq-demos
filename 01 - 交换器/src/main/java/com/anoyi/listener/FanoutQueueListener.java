package com.anoyi.listener;

import com.anoyi.exchange.FanoutExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FanoutQueueListener {

    @RabbitListener(queues = FanoutExchangeConfig.QUEUE_1)
    public void listenFanoutQueue1(String message) {
        log.info("[{}] {}", FanoutExchangeConfig.QUEUE_1, message);
    }

    @RabbitListener(queues = FanoutExchangeConfig.QUEUE_2)
    public void listenFanoutQueue2(String message) {
        log.info("[{}] {}", FanoutExchangeConfig.QUEUE_2, message);
    }

}
