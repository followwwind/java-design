package com.wind.example;

/**
 * @author wind
 */
public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new CommandImp(receiver);
        Invoker invoker = new Invoker(command);
        invoker.sendMsg("hello world");
    }
}
