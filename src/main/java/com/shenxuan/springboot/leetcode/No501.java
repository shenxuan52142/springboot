package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No501 {
    public int[] findMode(TreeNode root) {
       List<Integer> ss=new ArrayList<>();
       sss(ss,root);
        List<Integer> resL = new ArrayList<>();
        int a = 1;
        int b = 0;
        int d = 1;
        for (int i = 0; i <ss.size() ; i++) {
            int c = ss.get(i);
            if (i!=0){

            if (c==b){
                d = d + 1;
            }else {
                if (d>a){
                    resL.clear();
                    resL.add(ss.get(i));
                    a = d;
                }
                if (d==a){
                    resL.add(ss.get(i));
                }
                d = 1;
            }
            }
            b = c;
        }
        int[] bb = ss.stream().mapToInt(Integer::valueOf).toArray();
        return bb;
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

    public void tset(List<Integer> ss){
        List<Integer> resL = new ArrayList<>();
        int a = 1;
        int b = 0;
        int d = 1;
        for (int i = 0; i <ss.size() ; i++) {
            int c = ss.get(i);
            if (i!=0){

                if (c==b&&i!=ss.size()-1){
                    d = d + 1;
                }else {
                    if (c==b){
                        d = d + 1;
                    }
                    if (d>a){
                        resL.clear();
                        resL.add(b);
                    }
                    if (d==a){
                        resL.add(b);
                    }
                    a = Math.max(a,d);
                    d = 1;
                    if (i==ss.size()-1&&a==1){
                        resL.add(c);
                    }
                }
            }
            b = c;
        }
        int ffff = 0;
    }
}
