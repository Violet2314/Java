package com.itheima.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    public static String getCode(){
      //自己练习
        Random r = new Random();
        int idex = r.nextInt(5);
        String s = "";
        for(int i = 0; i < 5; i++){
            if(i == idex){
                int now = r.nextInt(9);
                s += Integer.toString(now);
            }else {
                int so = r.nextInt(2);
                int now = r.nextInt(26);
                if(so == 0){
                    char nowso = (char) ('A' + now);
                    s += nowso;
                } else {
                    char nowso = (char) ('a' + now);
                    s += nowso;
                }
            }
        }
        return s;
    }
}