package com.shenxuan.springboot.leetcode;

public class No543 {
    int b = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        hight(root);
        return b;
    }

    public int hight(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        int left = hight(treeNode.left);
        int right = hight(treeNode.right);
        b=Math.max(left+right,b);
        return Math.max(left,right)+1;
    }
}
