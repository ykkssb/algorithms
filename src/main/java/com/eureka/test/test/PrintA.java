package com.eureka.test.test;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-24 15:25
 */
public class PrintA implements Runnable {
    private Num num;
    public PrintA(Num n){
        this.num = n;
    }

   @Override
    public void run(){
       for(;;){
           num.print();
       }
   }
}
