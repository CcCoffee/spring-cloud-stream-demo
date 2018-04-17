package com.zhengkehui;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @Author zhengkehui
 * @Date 2018/4/17 13:22
 * @Description
 */
@EnableBinding({MyProcesser.class})
public class Revicever {

    // 监听 binding 为 Processor.INPUT 的消息
    @StreamListener(MyProcesser.INPUT)
    public void input(Message<String> message) {
        System.out.println("一般监听收到：" + message.getPayload());
    }


}
