package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
           sss(res,root);
//        List<Integer> res1 = new ArrayList<>();
//        res1.addAll(res);
//        Collections.sort(res1);
//        for (int i = 0; i <res.size(); i++) {
//            if (res.get(i)!=res1.get(i)){
//                return false;
//            }
//        }
//        return true;
        int a = 0;
        int b = 0;
        for (int i = 0; i <res.size() ; i++) {
            b = res.get(i);
            if (i!=0){
                if (a>=b){
                    return false;
                }
            }
            a = b;
        }
        return true;
    }


    public void sss(List<Integer> list, TreeNode treeNode){
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
