package com.shenxuan.springboot.leetcode;

import java.util.*;

public class No1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2map = new LinkedHashMap<>();
        List<Integer> aaa = new ArrayList<>();
        for (int i = 0; i <arr2.length ; i++) {
            arr2map.put(arr2[i], 0);
    }
        for (int i = 0; i <arr1.length ; i++) {
            if (arr2map.containsKey(arr1[i])){
                    Integer ii = arr2map.get(arr1[i]);
                    arr2map.replace(arr1[i],ii+1);
            }else {
                aaa.add(arr1[i]);
            }
        }
        int[] ret = new int[arr1.length];
        int bbb = 0;
        for (Map.Entry<Integer, Integer> entry : arr2map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i <value ; i++) {
                ret[bbb] = key;
                bbb = bbb + 1;
            }
        }
       Collections.sort(aaa);
        for (int i = 0; i <aaa.size() ; i++) {
            ret[bbb] = aaa.get(i);
            bbb=bbb + 1;
        }
        return ret;
    }
}
