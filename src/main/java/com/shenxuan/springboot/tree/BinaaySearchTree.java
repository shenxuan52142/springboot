package com.shenxuan.springboot.tree;

import java.nio.BufferUnderflowException;

public class BinaaySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<Anytype> {
        Anytype element;
        BinaryNode<Anytype> left;
        BinaryNode<Anytype> right;

        BinaryNode(Anytype element) {
            this(element, null, null);
        }

        BinaryNode(Anytype el, BinaryNode<Anytype> le, BinaryNode<Anytype> rt) {
            element = el;
            left = le;
            right = rt;
        }
    }

    private BinaryNode<AnyType> root;

    public BinaaySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType finMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findmax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {

    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
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
        return null;
    }

    private BinaryNode<AnyType> findmax(BinaryNode<AnyType> t) {
        return null;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        return null;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        return null;
    }

    private void printTree(BinaryNode<AnyType> t) {

    }

}
