package com.shenxuan.springboot.leetcode;

public class No21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode returnList = new ListNode(0);
        ListNode next = new ListNode(0);
        returnList.next = next;
        while (l1 != null && l2 != null) {
            ListNode curr = new ListNode(0);
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.val = l1.val;
                    l1 = l1.next;
                } else {
                    curr.val = l2.val;
                    l2 = l2.next;
                }
            }
            ListNode node1 = next;
            node1.next = curr;
            next = curr;
        }

        if (l1 != null) {
            next.next = l1;
        }
        if (l2 != null) {
            next.next = l2;

        }
        return returnList.next.next;
    }
}
