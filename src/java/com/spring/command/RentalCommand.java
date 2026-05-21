package com.spring.command;
// 抽象命令接口 定义了执行命令 撤销命令 和获取命令名称的方法
public interface RentalCommand {
    boolean execute();// 执行命令
    void undo();// 撤销命令
    String getCommandName();// 获取命令名称
}
