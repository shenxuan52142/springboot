package com.shenxuan.springboot.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1160 {
    public int countCharacters(String[] words, String chars) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <chars.length() ; i++) {
            if (map.containsKey(chars.substring(i,i+1))){
                map.replace(chars.substring(i, i + 1), map.get(chars.substring(i, i + 1)) + 1);
            }else {
                map.put(chars.substring(i, i + 1), 1);
            }
        }
        int re = 0;
        for (int i = 0; i <words.length ; i++) {
           Map<String, Integer> map2 = new HashMap<>();
           map2.putAll(map);
            String ss = words[i];
            first: for (int j = 0; j <ss.length() ; j++) {
                if (map2.containsKey(ss.substring(j, j + 1))) {
                    int bb = map2.get(ss.substring(j, j + 1));
                    if (bb > 0) {
                        bb = bb - 1;
                        map2.replace(ss.substring(j, j + 1), bb);
                        if (j==ss.length()-1){
                            re = re + words[i].length();
                        }
                    }else {
                        break first;
                    }
                }else {
                    break first;
                }
            }
        }


        return re;
    }

    public int countCharacters1(String[] words, String chars) {
        int re = 0;
        int[] aa = new int[30];
        for (char c:chars.toCharArray()) {
            aa[c - 'a']++;
        }
        for (String s:words){
            int[] bb = aa.clone();
            char[] sss = s.toCharArray();
            first:  for (int i=0;i<sss.length;i++){
                if (bb[sss[i]-'a']>0){
                    bb[sss[i] - 'a']--;
                    if (i==sss.length-1){
                        re = s.length() + re;
                    }
                }else {
                  break first;
                }
            }
        }
        return re;
    }

}
