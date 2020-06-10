package com.shenxuan.springboot.Synchronized;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class Mutex implements Lock {
    //静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer{
        //判断是否处于占用状态
        protected boolean isHeldExclusively(){
            LockSupport.park();
            LockSupport.unpark(Thread.currentThread());
            return getState() == 1;
        }
        //状态为0时的时候获取锁
        public boolean tryAcquire(int acquires){
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
             //   HashMap ss = new HashMap();
            }
            return false;
        }
        //释放锁 将状态设置为0
        protected boolean tryRelease(int releaase){
            if (getState()==0) throw new IllegalMonitorStateException();

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        //返回一个Condition,每一个condition都包含了一个cond队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }



    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
