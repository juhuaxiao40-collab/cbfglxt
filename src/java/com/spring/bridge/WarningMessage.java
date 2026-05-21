package com.spring.bridge;

public class WarningMessage extends Message{
    public WarningMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String content) {
        sender.send("【警告】" + content);
    }
}
