package com.pf.app.api.util;

import java.util.Calendar;
import java.util.Random;

public class RandomNumUtil {
    /**
     * 格式：yyyymmddhhMMssSSS+2位随机
     * @return
     */
    public static long generateyyyymmddhhMMssSSSAnd2Random0() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) * 1000000000000000l
                + (c.get(Calendar.MONTH) + 1) * 10000000000000l
                + c.get(Calendar.DAY_OF_MONTH) * 100000000000l
                + c.get(Calendar.HOUR_OF_DAY) * 1000000000l
                + c.get(Calendar.MINUTE) * 10000000l
                + c.get(Calendar.SECOND) * 100000
                + c.get(Calendar.MILLISECOND) * 100
                + (int)(Math.random() * 100);
    }
    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }

    public static String get6RandNum(){

        Integer number = new Random().nextInt(1000000);
        String code = "000000" + Integer.toString(number);
        return code.substring(code.length() - 6);

        //return getRandNum(1,999999)+"";
    }

    public static void main(String [] args){
       System.out.println(getRandNum(1,999999));
    }

}
