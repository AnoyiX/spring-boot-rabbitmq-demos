package com.anoyi.service;

import com.anoyi.bean.MessageRequestBean;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    /**
     * 向 RabbitMQ 发送消息
     */
    public void sendMessage(MessageRequestBean messageRequestBean){
        for (int i = 0; i < messageRequestBean.getCount(); i++) {
            String content = String.format("[%4d] %s", i, messageRequestBean.getContent());
            rabbitTemplate.convertAndSend(messageRequestBean.getExchange(), messageRequestBean.getRoutingKey(), content);
        }
    }

}
