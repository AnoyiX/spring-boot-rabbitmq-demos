package com.anoyi.listener;

import com.anoyi.config.DelayedMessageExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DelayedMessageQueueListener {

    /**
     * 监听延迟队列消息
     */
    @RabbitListener(queues = DelayedMessageExchangeConfig.QUEUE_DELAYED_MESSAGE)
    public void listenTTL(String message) {
        log.info("[{}] {}", DelayedMessageExchangeConfig.QUEUE_DELAYED_MESSAGE, message);
    }

}
