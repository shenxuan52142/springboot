package com.shenxuan.springboot.leetcode;

public class No54 {
    public int kthLargest(TreeNode root, int k) {
        count = k;
       print(root);
        return re;
    }

    private int count = 0;
    private int re = 0;
    private void print(TreeNode root) {
        if (count==0){
            return;
        }
        if (root==null){
            return;
        }
        print(root.right);
        count--;
        if (count==0){
            re = root.val;
        }
        print(root.left);
    }
}
