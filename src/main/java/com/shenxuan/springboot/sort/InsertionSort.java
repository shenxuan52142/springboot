package com.shenxuan.springboot.sort;

public class InsertionSort {
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType [] anyTypes){
        int j;

        for (int p=1; p<anyTypes.length;p++){

            AnyType tem = anyTypes[p];
            for (j=p;j>0&&tem.compareTo(anyTypes[j-1])<0;j--)
                anyTypes[j] = anyTypes[j - 1];
            anyTypes[j] = tem;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void shellsort(AnyType [] a){
        int j;


        for (int gap= a.length/2;gap>0;gap=gap/2){
            for (int i = gap; i <a.length ; i++) {
                AnyType tem = a[i];
                for (j = i; j>=gap&&tem.compareTo(a[j-gap])<0 ; j-=gap) {
                    a[j] = a[j - gap];

                }
                a[j] = tem;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] aa = {34, 8, 64, 51, 32, 21};
        InsertionSort.insertionSort(aa);

    }

    public static void shellsort(int[] a){
        int j;
        for (int gap=a.length/2;gap>0;gap/=2){
            for (int i = gap; i <a.length ; i++) {
                int b = a[i];
                for (j=i;j>=gap&&b<a[j-gap];j-=gap){
                    a[j]=a[j-gap];
                }
                a[j] = b;
            }
        }

    }
}
