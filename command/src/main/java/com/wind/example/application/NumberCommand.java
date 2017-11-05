package com.wind.example.application;

/**
 * 打印九九乘法表命令
 * @author wind
 */
public class NumberCommand implements ICommand {

    private PrintNumber printNumber;

    public NumberCommand(PrintNumber printNumber) {
        this.printNumber = printNumber;
    }

    @Override
    public void execute() {
        System.out.println();
        printNumber.printMultable();
    }
}
