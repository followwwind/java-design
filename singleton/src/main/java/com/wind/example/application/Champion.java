package com.wind.example.application;

/**
 * 冠军实例
 * @author wind
 */
public class Champion {

    private static Champion uniqueChampion;

    String message;

    private Champion(String message){
        uniqueChampion = this;
        this.message = message;
    }

    /**
     * 设置冠军
     * @param message
     * @return
     */
    public static synchronized Champion setChampion(String message){
        if(uniqueChampion == null){
            uniqueChampion = new Champion(message + "是冠军!!!");
        }

        return uniqueChampion;
    }

    public static void initChampion(){
        uniqueChampion = null;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 是否产生冠军
     * @return
     */
    public static boolean isChampion(){
        return uniqueChampion != null ? true : false;
    }
}
