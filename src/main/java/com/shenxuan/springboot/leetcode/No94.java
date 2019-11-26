package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        sss(res,root);
        return res;
    }


    public void sss(List<Integer> list,TreeNode treeNode){
        if (treeNode!=null){
            if (treeNode.left!=null){
                sss(list,treeNode.left);
            }
            list.add(treeNode.val);
            if (treeNode.right!=null){
                sss(list,treeNode.right);
            }
        }
    }
}
