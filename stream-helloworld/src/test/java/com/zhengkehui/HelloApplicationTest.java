package com.zhengkehui;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
@DirtiesContext
@EnableBinding(SinkSender.class)
public class HelloApplicationTest
{
    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
        //output方法注解绑定的是"input"通道
        sinkSender.output().send(MessageBuilder.withPayload("**************From SinkSender").build());

    }
}
