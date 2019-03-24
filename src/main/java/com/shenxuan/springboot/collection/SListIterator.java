package com.shenxuan.springboot.collection;

public interface SListIterator<T> {
    boolean hasNext();
    T next();
    void remove();
    void add(T element);
}
