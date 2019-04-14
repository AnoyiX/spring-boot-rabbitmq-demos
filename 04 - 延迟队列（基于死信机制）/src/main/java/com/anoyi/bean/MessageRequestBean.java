package com.anoyi.bean;

import lombok.Data;

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
     * 内容
     */
    private String content;

    /**
     * 延迟时间
     */
    private String delayTime;

}
