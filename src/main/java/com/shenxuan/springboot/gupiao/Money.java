package com.shenxuan.springboot.gupiao;

import com.shenxuan.springboot.IO.Use.TextFile;

import java.util.Arrays;
import java.util.List;

public class Money {
    public static List<String> getGuPiaoId(){
        String var1 = TextFile.read("C:\\gupiao\\gupiaoID.out");
        List<String> list = Arrays.asList(",", var1);
        return list;
    }
    public static boolean yiYangChuanSanXian(Gupiao gupiao){
        boolean result = false;
        float day_5 = gupiao.getMa5();
        float day_10 = gupiao.getMa10();
        float day_20 = gupiao.getMa20();
        float day_30 = gupiao.getMa30();
        double close = gupiao.getClose();
        if (chaZhi(day_5,day_10)&&chaZhi(day_5,day_20)&&chaZhi(day_5,day_30)){
            result = true;
        }

        return result;
    }

    public static boolean chaZhi(float a,float b){
        boolean result = false;
        float c = a/(a+b);
        float d = b / (a + b);
        if (0.4975<c && c<0.5025){
            if (0.4975<d && d<0.5025) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        float a=7.22f;
        float b=7.27f;
        System.out.println(chaZhi(a,b));
    }
}
