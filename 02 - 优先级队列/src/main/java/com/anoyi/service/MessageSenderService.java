package com.anoyi.service;

import com.anoyi.config.RabbitConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;

    /**
     * 发送消息到普通队列
     */
    public void sendToNormalQueue(String message){

        rabbitTemplate.convertAndSend(RabbitConfig.NORMAL_EXCHANGE, RabbitConfig.NORMAL_ROUTING_KEY, message);

    }

}
