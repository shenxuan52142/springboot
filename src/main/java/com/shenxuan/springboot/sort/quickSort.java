package com.shenxuan.springboot.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quickSort {
    public static void sort(List<Integer> items){
        if (items.size()>1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer choseItem = items.get(items.size() / 2);
            for (Integer i:items){
                if (i<choseItem){
                    smaller.add(i);
                }
                else if (i>choseItem){
                    larger.add(i);
                }
                else {
                    same.add(i);
                }
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }

    }
    public static void quick(int arr[],int left,int right){
        if (left < right) {

            int i = Qsort(arr, left, right);
            quick(arr, left, i);
            quick(arr,i+1,right);
        }

    }

    public static int Qsort(int arr[],int left,int right){
        int i = left;
        int temp = arr[i];
        int m = left;
        int n = right;
        while (m<n){
            while (arr[m]<=temp&&m<right){
                m++;
            }
            while (arr[n]>=temp&&n>left){
                n--;
            }
            if (m<n){
                int k = arr[m];
                arr[m] = arr[n];
                arr[n] = k;
            }
        }
        arr[i] = arr[n];
        arr[n] = temp;
        return n;
    }
    public static void main(String[] args) {
    int a[]=new int[]{8, 1};
        quick(a, 0, 1);
        System.out.println(a);
        HashMap ss = new HashMap();
    }
}
