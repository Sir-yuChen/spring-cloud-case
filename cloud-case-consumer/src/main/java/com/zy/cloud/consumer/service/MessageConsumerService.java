package com.zy.cloud.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

//这里是消息消费者，所以就就是接收者，所以使用Sink
@EnableBinding(Sink.class)
public class MessageConsumerService {

    @Value("${server.port}")
    private String port;

    //监听消息
    @StreamListener(Sink.INPUT)
    public void recevieMes(Message<String> message) {
        //监听MQ但是不会消费堆积的消息 所有的消费者都会接到相同的消息，消费，消息重复 原因：组流水号不一样 【自定义组名即可解决】
        /*
        *   在RabbitMQ中，默认分组是不同的，组流水号不一样，被认为不同组，我们查看testExchange交换机，可以发现8802和8803两个消息消费者处于不同的组，
        *       所以8801消息生产者发送的消息可以被这两个消费者重复消费：
        * */
        System.out.println("--" + port + "---Consumer springcloud Stream 消费消息：" + message.getPayload());
    }
}
