package com.shenxuan.springboot.sort;

public class mergeSort {
    private static <AnyType extends Comparable<? super AnyType>>
            void mergeSort(AnyType[] a,AnyType [] tmpArray,int left,int right){
        if (left<right){
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a,tmpArray,center+1,right);
        }
    }





    private static <AnyType extends Comparable<? super AnyType>>
            void mergeSort(AnyType [] a){
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a,tmpArray,0,a.length-1);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType [] a,AnyType tmpArray, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos<=leftEnd && rightPos<=rightEnd){
            
        }
    }

}
