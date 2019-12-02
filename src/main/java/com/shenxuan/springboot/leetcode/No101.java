package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No101 {
//    public boolean isSymmetric(TreeNode root) {
//        List<Integer> ss = new ArrayList<>();
//        sss(ss,root);
//        if (a%2==1){
//            return false;
//        }
//        if (ss.size()%2==0){
//            return false;
//        }else {
//            for (int i = 0; i <ss.size()/2 ; i++) {
//                if (ss.get(i)!=ss.get(ss.size()-i-1)){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    int a = 0;
//        public void sss(List<Integer> list, TreeNode treeNode){
//
//            if (treeNode!=null){
//                if (treeNode.left!=null){
//                    sss(list,treeNode.left);
//                }else if (treeNode.right!=null){
//                    list.add(0);
//                    a = a + 1;
//                }
//                list.add(treeNode.val);
//                if (treeNode.right!=null){
//                    sss(list,treeNode.right);
//                }else if (treeNode.left!=null){
//                    list.add(0);
//                    a = a + 1;
//                }
//            }
//        }
//    递归
//    public boolean isSymmetric(TreeNode root) {
//        return isSymme(root, root);
//    }
//
//
//    public boolean isSymme(TreeNode t1,TreeNode t2){
//        if (t1==null&&t2==null){
//            return true;
//        }
//        if ((t1==null&&t2!=null)||(t1!=null&&t2==null)){
//            return false;
//        }
//
//        return t1.val == t2.val && isSymme(t1.left, t2.right) && isSymme(t1.right, t2.left);
//    }

    //    迭代
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
                return false;
            }
            if (t1.val!=t2.val){
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
