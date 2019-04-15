package com.anoyi.listener;

import com.anoyi.exchange.HeadersExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class HeadersQueueListener {

    @RabbitListener(queues = HeadersExchangeConfig.QUEUE_1)
    public void listenHeadersQueue1(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConfig.QUEUE_1, stringBuilder.toString(), new String(message.getBody()));
    }

    @RabbitListener(queues = HeadersExchangeConfig.QUEUE_2)
    public void listenHeadersQueue2(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConfig.QUEUE_2, stringBuilder.toString(), new String(message.getBody()));
    }

    @RabbitListener(queues = HeadersExchangeConfig.QUEUE_3)
    public void listenHeadersQueue3(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConfig.QUEUE_3, stringBuilder.toString(), new String(message.getBody()));
    }

}
