package com.shenxuan.springboot.tree;

public class AvlNode<AnyTpye> {
    AvlNode(AnyTpye element) {
        this(element, null, null);
    }
    AvlNode(AnyTpye theelement,AvlNode<AnyTpye> lt,AvlNode<AnyTpye> rt){

    }

    AnyTpye element;
    AvlNode<AnyTpye> left;
    AvlNode<AnyTpye> right;
    int height;

    private int height(AvlNode<AnyTpye> t){
        return t == null ? -1 : t.height;
    }

}
