package com.shenxuan.springboot.leetcode;

import java.util.Stack;

public class No20 {
    public boolean isValid(String s) {
        Stack<Character> strings = new Stack<>();
        if (s==null||"".equals(s)){
            return true;
        }
        for (Character bar:s.toCharArray()){
            if (strings.empty()){
                strings.push(bar);
            }else {
                if (conpare(bar,strings.peek())){
                    strings.pop();
                }else {
                    strings.push(bar);
                }
            }
        }
        if (strings.empty()){
            return true;
        }else {
            return false;
        }
    }
   private boolean conpare(char b,char a){
        if ('{'==a&&'}'==b){
            return true;
        }
       if ('('==a&&')'==b){
           return true;
       }
       if ('['==a&&']'==b){
           return true;
       }
       return false;
   }

}
