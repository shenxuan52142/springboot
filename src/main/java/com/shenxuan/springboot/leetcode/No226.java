package com.shenxuan.springboot.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No226 {
//    public TreeNode invertTree(TreeNode root) {
//            if (root==null){
//                return null;
//            }
//
//        TreeNode right = invertTree(root.right);
//        TreeNode left = invertTree(root.left);
//
//        root.left = right;
//        root.right = left;
//        return root;
//
//    }
//    public TreeNode invertTree(TreeNode root) {
//        if (root==null)
//            return null;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            TreeNode current = queue.poll();
//            TreeNode temp = current.left;
//            current.left = current.right;
//            current.right = temp;
//            if (current.left!=null){
//                ((LinkedList<TreeNode>) queue).add(current.left);
//            }
//            if (current.right!=null){
//                queue.add(current.right);
//            }
//        }
//        return root;
//
//    }
public TreeNode invertTree(TreeNode root) {
    if (root==null)
        return null;
    TreeNode curr = root.left;
    root.left = root.right;
    root.right = curr;
    if (root.right!=null){
        invertTree(root.right);
    }
    if (root.left!=null){
        invertTree(root.left);
    }
    return root;
}
}
