package com.anoyi.listener;

import com.anoyi.config.DirectExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DirectQueueListener {

    /**
     * 监听优先级队列的消息
     */
    @RabbitListener(queues = DirectExchangeConfig.QUEUE)
    public void listen(Message message) throws Exception{
        // 模拟业务处理
        Thread.sleep(1000);
        log.info("[priority] {} [content] {}", message.getMessageProperties().getPriority(), new String(message.getBody()));
    }

}
