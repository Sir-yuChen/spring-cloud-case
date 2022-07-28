package com.zy.cloud.produce.controller;


import com.zy.cloud.produce.mq.IMessageProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MqController {

    private static Logger logger = LogManager.getLogger(MqController.class);

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public boolean sendMessage() {
        logger.error("error 发送消息 elk test~~~~~~");
        logger.info("info 发送消息 elk test~~~~~~");
        logger.warn("warn 发送消息 elk test~~~~~~");
        return iMessageProvider.send();
    }


}
