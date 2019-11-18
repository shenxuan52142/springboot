package com.shenxuan.springboot.tree;

public class TreeNode<AnyType> {
    AnyType element;
    TreeNode<AnyType> left;
    TreeNode<AnyType> right;

    TreeNode(AnyType element){
        this(element, null, null);
    }

    TreeNode(AnyType el,TreeNode<AnyType> le,TreeNode<AnyType> rt){
        element = el;
        left = le;
        right = rt;
    }
}
