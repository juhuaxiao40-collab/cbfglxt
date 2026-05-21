package com.spring.bridge;

public class NotificationMessage  extends Message{
    public NotificationMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String content) {
        sender.send("【通知】" + content);
    }
}
