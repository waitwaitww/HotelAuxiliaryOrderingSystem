package com.code.back.util;

public class ControllerUtils {

    public static float starConversion(String star){
        if(star.equals("选项1"))   return 5;
        else if(star.equals(("选项2")))  return 4;
        else if(star.equals(("选项3"))) return 3;
        else return -1;
    }
}
