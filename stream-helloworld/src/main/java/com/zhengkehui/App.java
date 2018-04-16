package com.zhengkehui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.Message;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @InboundChannelAdapter(value = Source.OUTPUT)
    public String timerMessageSource() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("publish message :"+format);
        return format;
    }
}

