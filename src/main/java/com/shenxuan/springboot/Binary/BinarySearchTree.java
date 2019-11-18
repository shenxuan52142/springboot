package com.shenxuan.springboot.Binary;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType>{
        BinaryNode(AnyType theElement){
            this(theElement,null,null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    //查找是否包含某个元素
    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public boolean contains(AnyType x,BinaryNode<AnyType> t){
        //注意判断 t是不是空
        if (t==null){
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult<0){
            return contains(x, t.left);
        }else if (compareResult>0){
            return contains(x, t.right);
        }else {
            return true;
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t!=null){
            while (t.left!=null){
                t = t.left;
            }
        }
        return t;
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t!=null){
            while (t.right!=null){
                t = t.right;
            }
        }
        return t;
    }
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if (t==null){
            return new BinaryNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult<0){
            return insert(x, t.left);
        }else if (compareResult>0){
            return insert(x, t.right);
        }else {

        }
        return t;
    }
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        return null;
    }
    private void printTree(BinaryNode<AnyType> t){

    }
}
