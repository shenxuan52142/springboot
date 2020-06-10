package com.shenxuan.springboot.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class No820 {
    public int minimumLengthEncoding(String[] words) {
        int c = 0;
        HashSet<String> wordss = new HashSet(Arrays.asList(words));
        for (String s: words) {
            for (int i = 1; i < s.length(); i++) {
                wordss.remove(s.substring(i));
            }
        }

        for (String a:
             wordss) {
            c = c + a.length();
        }
        return c;
    }
}
