package com.anoyi.controller;

import com.anoyi.bean.MessageRequestBean;
import com.anoyi.service.MessageSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageSender messageSender;

    @PostMapping("/send")
    public String send(@RequestBody MessageRequestBean messageRequestBean){
        messageSender.sendMessage(messageRequestBean);
        return "success";
    }

}
