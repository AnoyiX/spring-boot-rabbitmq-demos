package com.anoyi.bean;

import lombok.Data;

import java.util.Map;

@Data
public class MessageRequestBean {

    /**
     * 交换器
     */
    private String exchange;

    /**
     * 路由键
     */
    private String routingKey;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 消息 headers
     */
    private Map<String, String> headers;

    /**
     * 内容
     */
    private String content;

}
