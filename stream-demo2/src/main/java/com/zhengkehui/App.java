package com.zhengkehui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    @Qualifier(MyProcesser.OUTPUT)
    MessageChannel output;

    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("字符串信息发送");
        output.send(MessageBuilder.withPayload("大家好").build());
    }
}
