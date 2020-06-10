package com.shenxuan.springboot.sort;

import java.nio.BufferUnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    public BinaryHeap() {

    }

    public BinaryHeap(int capacity){

    }
    public BinaryHeap(AnyType[] items){
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10 ];

}

    public void insert(AnyType x){
       if (currentSize==array.length-1){
           enlargeArray(array.length*2+ 1);
       }
       //currentSize+1
        int hole = ++currentSize;
       for (array[0] = x;x.compareTo(array[hole/2])<0;hole/=2){
           array[hole] = array[hole / 2];
       }
        array[hole] = x;

    }
    public AnyType findMin(){
        return null;
    }
    public AnyType deleteMin(){
        if (isEmpty()){
            throw new BufferUnderflowException();
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }
    public boolean isEmpty(){
        return true;
    }
    public void makeEmpty(){

    }

    private static final int DEFAULT_CAPACITY = 10;
    //Number of elemetns in heap
    private int currentSize;
    private AnyType[] array;
    private void percolateDown(int hole){
        int child;
        AnyType tmp = array[hole];
        for (;hole*2<=currentSize;hole=child){
            child = hole * 2;
            if (child!=currentSize&&array[child+1].compareTo(array[child])<0){
                child++;
            }

            if (array[child].compareTo(tmp)<0){
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }
    private void buildHeap(){

    }
    private void enlargeArray(int newSize){

    }
}
