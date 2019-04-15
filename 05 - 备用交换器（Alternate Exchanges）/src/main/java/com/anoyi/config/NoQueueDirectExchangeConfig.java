package com.anoyi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 备用交换器
 */
@Configuration
@Slf4j
public class NoQueueDirectExchangeConfig {

    public static final String EXCHANGE = "exchange-direct-no-queue";

    @Bean
    DirectExchange directNoQueueExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("alternate-exchange", "exchange-direct-alternate");
        return new DirectExchange(EXCHANGE, false, false, args);
    }

}
