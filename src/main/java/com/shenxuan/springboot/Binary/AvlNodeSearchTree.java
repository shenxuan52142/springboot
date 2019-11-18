package com.shenxuan.springboot.Binary;



public class AvlNodeSearchTree <AnyType extends Comparable<? super AnyType>>{
    private static class AvlNode<AnyType>{
        AvlNode(AnyType theElement){
            this(theElement, null, null);
        }
        AvlNode(AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }

        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;
    }
    //节点高度
    private int height(AvlNode<AnyType> t){
        return t == null ? -1 : t.height;
    }


}
