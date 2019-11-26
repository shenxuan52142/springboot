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

    public static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<AnyTpye> balanced(AvlNode<AnyTpye> t){
        if (t==null){
            return t;
        }
        if (height(t.left)-height(t.right)>ALLOWED_IMBALANCE){

        }
        return null;
    }
    private AvlNode<AnyTpye> rotateWithLeftChild(AvlNode<AnyTpye> k2){
        AvlNode<AnyTpye> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

}
