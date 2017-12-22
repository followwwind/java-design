package com.wind.example.advance;

import java.util.Random;

/**
 * 打印英语单词命令
 * @author wind
 */
public class EnglishCommand implements ICommand{

    private PrintLetter printLetter;

    public EnglishCommand(PrintLetter printLetter) {
        this.printLetter = printLetter;
    }

    @Override
    public void execute() {
        System.out.println();
        int i = new Random().nextInt(2);
        if(i == 0){
            printLetter.printLower();
        }else{
            printLetter.printUpper();
        }
    }
}
