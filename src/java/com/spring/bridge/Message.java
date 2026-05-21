// 消息发送抽象类
package com.spring.bridge;

public abstract class Message {
    protected MessageSender sender;
    
    public Message(MessageSender sender) {
        this.sender = sender;
    }
    
    public abstract void send(String content);
}
