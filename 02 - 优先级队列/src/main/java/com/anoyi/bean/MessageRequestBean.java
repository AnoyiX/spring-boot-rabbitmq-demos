package com.anoyi.bean;

import lombok.Data;

@Data
public class MessageRequestBean {

    /**
     * 内容
     */
    private String content;

    /**
     * 数量
     */
    private Integer count;

}
