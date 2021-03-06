package com.shenxuan.springboot.collection;


import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

public class SList<T> {
   private static class Link<T>{
       T element;
       Link<T> next;
       Link(T element,Link<T> next){
           this.element=element;
           this.next=next;
       }
    }

    private final Link<T> header = new Link<T>(null, null);
    SList(){

    }
    private class SListIteratorImpl implements SListIterator<T>{
        private Link<T> lastReturned = header;
        private Link<T> next;
        //初始化
        SListIteratorImpl() {
            next = header.next;
        }

        @Override
        public boolean hasNext() {
            return next!=header.next;
        }

        @Override
        public T next() {
            if (next==header){
                throw new NoSuchElementException();
            }
            lastReturned=next;
            next=next.next;
            return lastReturned.element;
        }

        @Override
        public void remove() {

        }

        @Override
        public void add(T element) {
            lastReturned = header;
            Link<T> newLink = new Link<T>(element, next);
            if(header.next == header) {
                header.next = newLink;
            }
            else {
                // Find an element before the one pointed by 'next'
                for(Link<T> curr = header; ; curr = curr.next)
                    if(curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
            }
        }
    }


    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(5);
//        list.add(45);
//        list.add(56);
//
//        for (Integer a:list){
//            if (a %2==0){
//                list.remove(a);
//            }
//        }

        List<String> list = Arrays.asList("sssss.ddd.ss".split(","));
        System.out.println(list);
    }
}
