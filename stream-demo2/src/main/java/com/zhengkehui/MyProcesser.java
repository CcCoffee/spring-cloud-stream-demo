package com.zhengkehui;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author zhengkehui
 * @Date 2018/4/17 13:26
 * @Description
 */
public interface MyProcesser {

    String OUTPUT = "myoutput";
    String INPUT = "myinput";

    @Input(MyProcesser.INPUT)
    SubscribableChannel input();

    @Output(MyProcesser.OUTPUT)
    MessageChannel output();


}
