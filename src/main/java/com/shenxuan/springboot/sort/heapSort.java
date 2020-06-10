package com.shenxuan.springboot.sort;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class heapSort {
    private static int leftchild(int i){
        return 2 * i + 1;
    }

    private static void porcdowm(int[] a,int i,int n){
        int child;
        int tmp;
        //i=2
        for (tmp=a[i];leftchild(i)<n;i=child){
            child = leftchild(i);//  child=5  n=7
            if (child!=n-1&&a[child]<a[child+1]){
                child++;  //clild=6
            }

            if (tmp<a[child]){
                a[i] = a[child];
            }else {
                break;
            }
            a[i] = tmp;
        }
    }

    public static void main(String[] args) throws ParseException {
        int i = 100;
        for (i = 100; i <56 ; i++) {
            System.out.println(34);
        }
        System.out.println(232);
        System.out.println(i);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String s = simpleDateFormat.format(date);
        Date d = simpleDateFormat.parse(s);
    }
}
