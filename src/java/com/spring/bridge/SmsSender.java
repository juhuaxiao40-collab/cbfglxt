package com.spring.bridge;

public class SmsSender implements MessageSender {
    @Override
    public void send(String content) {
        System.out.println("通过短信发送: " + content);
        // 实际短信发送逻辑
    }
}