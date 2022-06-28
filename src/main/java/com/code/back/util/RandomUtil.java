package com.code.back.util;

import java.util.Random;

public class RandomUtil {

    public static String  randomNumbers(int n){
        String str="0123456789";
        String uuid=new String();
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            uuid+=ch;
        }
        return uuid;
    }
}
