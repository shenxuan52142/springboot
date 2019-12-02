package com.shenxuan.springboot.leetcode;

public class No206 {
    public ListNode reverseList(ListNode head) {
        ListNode returnNode = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode node = curr.next;
            curr.next = returnNode;
            returnNode = curr;
            curr = curr.next;
        }
        return returnNode;
    }
}
