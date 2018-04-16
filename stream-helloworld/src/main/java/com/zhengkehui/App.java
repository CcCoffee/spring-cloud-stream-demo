package com.zhengkehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
@EnableBinding(Sink.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // 监听 binding 为 Sink.INPUT 的消息
    @StreamListener(Sink.INPUT)
    public void input(Message<byte[]> message) {
        byte[] bytes = message.getPayload();
        try {
            System.out.println("一般监听收到：" + new String(bytes, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

