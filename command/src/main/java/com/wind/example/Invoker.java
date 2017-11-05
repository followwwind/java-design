package com.wind.example;

/**
 * 命令模式请求者
 * @author wind
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void sendMsg(String message){
        System.out.println("发送消息:" + message);
        command.execute(message);
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
