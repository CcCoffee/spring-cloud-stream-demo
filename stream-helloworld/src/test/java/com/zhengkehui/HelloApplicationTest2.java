package com.zhengkehui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
@WebAppConfiguration
@DirtiesContext
public class HelloApplicationTest2 {

    @Autowired // 通过直接注入的方式注入通道，input Sink.INPUT
    private MessageChannel input;

    // 当有多个通道时，可通过名称指定
    @Autowired
    @Qualifier("input2") // 通过直接注入的方式注入通道，input Sink.INPUT
    private MessageChannel inputtest;

    @Test
    public void contextLoads() {
        input.send(MessageBuilder.withPayload("**************From SinkSender").build());// 发到input通道，有消费者
        inputtest.send(MessageBuilder.withPayload("#################From SinkSender").build());// 发到input2通道，无消费者
    }
}
