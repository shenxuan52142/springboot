package com.shenxuan.springboot.leetcode;

public class No538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
             if (root!=null){
                 convertBST(root.right);
                 sum = sum + root.val;
                 root.val=sum;
                 convertBST(root.left);
             }
             return root;
    }
}
