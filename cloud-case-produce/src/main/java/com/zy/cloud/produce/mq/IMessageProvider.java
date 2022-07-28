package com.zy.cloud.produce.mq;


// springcloud stream 发送消息接口
public interface IMessageProvider {
    boolean send();
}
