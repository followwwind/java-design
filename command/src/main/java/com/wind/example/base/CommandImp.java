package com.wind.example.base;

/**
 * 具体命令
 * @author wind
 */
public class CommandImp implements Command{

    private Receiver receiver;

    public CommandImp(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String message) {
        receiver.receiveMsg(message);
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
