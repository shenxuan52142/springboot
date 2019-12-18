package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int var = 0;
        boolean isZero = false;
        int aa = 0;
        int bb = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a!=null&&b!=null){

            if (a.val==b.val&&var==0&&!isZero){
                var = a.val;
            }else if (a.val!=b.val){
                var = 0;
            }

            if (a.val==0||b.val==0){
                isZero = true;
            }else {
                isZero = false;
            }
            if (a.next == null&&aa==0) {
                a = headB;
                aa = aa + 1;
            }else {
                a = a.next;
            }
            if (b.next==null&&bb==0){
                b = headA;
                bb = bb + 1;
            }else {
                b = b.next;
            }
        }
        if (var!=0){
            return new ListNode(var);
        }else {
            return null;
        }
    }

}
