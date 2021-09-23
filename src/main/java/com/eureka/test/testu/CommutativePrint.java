package com.eureka.test.testu;

import java.sql.Connection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-24 15:17
 */
public class CommutativePrint {


    public volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
//        Num n = new Num(0);
        Object b = new Object();
//        ReentrantLock l = new ReentrantLock();
//        Condition c1 = l.newCondition();
//        Condition c2 = l.newCondition();
//        Condition c3 = l.newCondition();
        ReentrantLock l = new ReentrantLock();
        Condition c1  = l.newCondition();
        Condition c2  = l.newCondition();
        Condition c3  = l.newCondition();

        new Thread(()->{
            for(int i=0;i<3;++i){
                l.lock();
                System.out.println("a");
                c2.signal();

                try{
                    Thread.sleep(1000);
                    c1.await();
                }catch(Exception e){

                }finally {
                    l.unlock();
                }
            }
        },"a").start();

        new Thread(
                ()->{
                    for(int i=0;i<3;++i){
                        l.lock();
                        System.out.println("b");
                        c3.signal();

                        try{
                            Thread.sleep(1000);
                            c2.await();
                        }catch(Exception e){

                        }finally{
                            l.unlock();
                        }
                    }
                }
                ,"b").start();

        new Thread(()->{
            for(int i=0;i<3;++i){
                l.lock();
                System.out.println("c");
                c1.signal();

                try{
                    Thread.sleep(1000);
                    c3.await();
                }catch(Exception e){

                }finally{
                    l.unlock();
                }
            }
        },"c").start();
      /*  new Thread(() -> {
            while (true) {
                l.lock();
                try {
                    System.out.println(Thread.currentThread().getName());

                    c2.signal();
                    c1.await();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l.unlock();
                }
            }
        }
                , "A").start();

        new Thread(() -> {
            while (true) {
                l.lock();
                try {
                    System.out.println(Thread.currentThread().getName());

                    c3.signal();
                    c2.await();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l.unlock();
                }
            }

        }
                , "B").start();
        new Thread(() -> {
            while (true) {
                l.lock();
                System.out.println(Thread.currentThread().getName());
                try {
                    c1.signal();
                    c3.await();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l.unlock();
                }
            }
        }
                , "C").start();
    }*/

    }
}
