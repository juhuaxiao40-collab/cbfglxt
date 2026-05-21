package com.spring.bridge;


public class EmailSender implements MessageSender {
    @Override
    public void send(String content) {
        System.out.println("通过邮件发送: " + content);
        // 实际邮件发送逻辑

    }
}
