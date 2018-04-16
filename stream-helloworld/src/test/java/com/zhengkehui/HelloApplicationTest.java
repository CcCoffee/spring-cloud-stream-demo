package com.zhengkehui;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
@WebAppConfiguration
@DirtiesContext
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
