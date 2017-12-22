package com.wind.example.advance;

import java.util.Arrays;

/**
 * 应用
 * @author wind
 */
public class Application {
    public static void main(String[] args) {
        PrintLetter printLetter = new PrintLetter();
        PrintNumber printNumber = new PrintNumber();
        ICommand enCommand = new EnglishCommand(printLetter);
        ICommand numCommnad = new NumberCommand(printNumber);
        ICommand listCommand = new ListCommand(Arrays.asList(enCommand, numCommnad));
        Requester requester = new Requester(listCommand);
        requester.action();
    }
}
