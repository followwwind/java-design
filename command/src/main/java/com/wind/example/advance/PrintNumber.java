package com.wind.example.advance;

/**
 * 命令接收者 打印数字
 * @author wind
 */
public class PrintNumber {
    /**
     * 打印9*9乘法表
     */
    public void printMultable(){
        for (int i = 1; i < 10; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i + "*" + j + "=" + i*j + "\t");
                if(i == j){
                    System.out.println();
                }
            }
        }
    }
}
