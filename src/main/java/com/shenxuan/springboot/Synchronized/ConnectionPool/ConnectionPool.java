package com.shenxuan.springboot.Synchronized.ConnectionPool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize){
     if (initialSize>0){
         for (int i = 0; i <initialSize ; i++) {
             pool.addLast(ConnectionDriver.createConnection());
         }
     }
    }

    public void releaseConnection(Connection connection){
        if (connection!=null){
            synchronized (pool){
                //释放连接后需要进行通知等待连接的消费者
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    //在mills内没有获取到连接，将会返回null
    public Connection fetchConnection(long mills)throws InterruptedException{
        synchronized (pool){
            if (mills<=0){
               while(pool.isEmpty()){
                   pool.wait();
               }
                return pool.removeFirst();
            }else {
                long feture = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty()&remaining>0){
                    pool.wait(remaining);
                    remaining = feture - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }


}
