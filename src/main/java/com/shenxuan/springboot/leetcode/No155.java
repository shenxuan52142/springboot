package com.shenxuan.springboot.leetcode;

public class No155 {
    /** initialize your data structure here. */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode root;
    public No155() {

    }

    public void push(int x) {
        if (root == null) {
            root = new ListNode(x);
        }else {
            ListNode curr = new ListNode(x);
            curr.next = root;
            root = curr;
        }
    }

    public void pop() {
       if (root!=null){
           root = root.next;
       }
    }

    public int top() {
        int a = 0;
        if (root!=null){
            a = root.val;
        }
        return a;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        return getMin(min,root);
    }

    private int getMin(int min,ListNode root){
        if (root!=null){
            min= getMin(min,root.next);
            min= Math.min(min, root.val);
        }
        return min;
    }


}
