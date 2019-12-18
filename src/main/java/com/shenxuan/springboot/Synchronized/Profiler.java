package com.shenxuan.springboot.Synchronized;

import java.util.concurrent.TimeUnit;

public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };

    private static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    private static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Profiler.end() );
    }
}
