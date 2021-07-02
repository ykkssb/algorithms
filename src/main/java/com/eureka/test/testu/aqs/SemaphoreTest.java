package com.eureka.test.testu.aqs;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-04-28 23:16
 */
public class SemaphoreTest {
    //停车场同时容纳的车辆10
    private  static Semaphore semaphore=new Semaphore(10);
    public static void main(String[] args) {
        //R
        for(int i=0;i<100;i++){
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("===="+Thread.currentThread().getName()+"来到停车场");
                        if(semaphore.availablePermits()==0){
                            System.out.println("车位不足，请耐心等待");
                        }
                        //获取令牌尝试进入停车场
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"成功进入停车场");
                        Thread.sleep(new Random().nextInt(1000));//模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName()+"驶出停车场");
                        //释放令牌，腾出停车场车位
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },i+"号车");
            thread.start();
        }
    }
}
