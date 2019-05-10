package com.shenxuan.springboot.concurrency.ALL;

public class EvenGenerator extends IntGenerator {
    public int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
}
