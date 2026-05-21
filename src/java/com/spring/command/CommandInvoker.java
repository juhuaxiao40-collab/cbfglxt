package com.spring.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 命令调用者类 用于执行命令并管理命令执行历史
@Component
public class CommandInvoker {

    private List<RentalCommand> commandHistory = new ArrayList<>();

    // 执行命令并将其添加到命令执行历史中
    public boolean executeCommand(RentalCommand command) {
        boolean result = command.execute();
        if (result) {
            commandHistory.add(command);
        }
        return result;
    }
    // 撤销最后一个执行的命令
    public boolean undoLastCommand() {
        if (commandHistory.isEmpty()) {
            return false;
        }

        RentalCommand lastCommand = commandHistory.remove(commandHistory.size() - 1);
        lastCommand.undo();
        return true;
    }
        // 显示命令执行历史
    public void showCommandHistory() {
        System.out.println("命令执行历史：");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ". " + commandHistory.get(i).getCommandName());
        }
    }
}