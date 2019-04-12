package com.anoyi.controller;

import com.anoyi.bean.MessageRequestBean;
import com.anoyi.service.MessageSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private MessageSenderService messageSenderService;

    @PostMapping("/send/normal-queue")
    public String normalQueue(@RequestBody MessageRequestBean messageRequestBean){
        int count = messageRequestBean.getCount();
        if (count < 1){
            count = 1;
        }
        for (int i = 0; i < count; i++) {
            String message = String.format(" [%d] %s", i, messageRequestBean.getContent());
            messageSenderService.sendToNormalQueue(message);
        }
        return "success";
    }

}
