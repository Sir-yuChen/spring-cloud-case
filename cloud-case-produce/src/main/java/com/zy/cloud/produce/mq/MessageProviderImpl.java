package com.zy.cloud.produce.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

//注意service的实现类中不再需要@Service注解，因为这个service不再是传统意义上的和Controller、DAO数据等进行交互的service，而是要绑定绑定器打交道的service。
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public boolean send() {
        String serial = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(serial).build());//发送消息
        System.out.println("====Produce springCloud stream 发送消息:====>:" + serial);
        return send;
    }
}
