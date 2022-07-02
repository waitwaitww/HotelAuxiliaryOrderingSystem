package com.code.back.util;

public class ControllerUtils {

    public static float starConversion(String star){
        if(star.equals("选项1"))   return 5;
        else if(star.equals(("选项2")))  return 4;
        else if(star.equals(("选项3"))) return 3;
        else return -1;
    }

    public static int setnum(String num){
        if (num.equals("一间"))   return 1;
        else if (num.equals("两间"))  return 2;
        else if (num.equals("三间"))  return 3;
        else if (num.equals("四间"))  return 4;
        else if (num.equals("五间"))  return 5;
        else return 1;
    }
}
