package edu.neu.csye6200.classes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Driver {
   public static void main(String[] args){

       Runnable r1 = new Runnable1();
       Thread t1 = new Thread(r1);
       Runnable r2 = new Runnable2();
       Thread t2 = new Thread(r2);
       t1.start();
       t2.start();
   }

       static class Runnable2 implements Runnable{
           public void run(){
               Demo demo = new Demo();
               demo.run();
               }
           }
       }

       class Runnable1 implements Runnable{

           public void run(){
                CheckClassNumber.getQuantity();

                while(true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    CheckClassNumber.checkQuantity();
                    CheckClassNumber.putQuantity();
                    System.out.println(CheckClassNumber.getClassroomsquantity());
                }



               }
           }



