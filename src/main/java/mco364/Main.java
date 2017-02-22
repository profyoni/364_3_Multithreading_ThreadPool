package mco364;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread1 extends Thread implements Runnable// option 1
{
    @Override
    public void run(){
        System.out.println("Running");
    }
}

class MyThread2 implements Runnable // option 2
{
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Running " + Thread.currentThread().getName());
    }
}

public class Main {


    
    public static void main(String[] args) {
        
        Thread t = new Thread(new MyThread2( ));
        
        t.run(); // runs on Main thread that runs program not a NEW hthread
        
        t.start(); // new Thread
        
        ScheduledThreadPoolExecutor pool;
        
        pool = new ScheduledThreadPoolExecutor(3);
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.execute(new MyThread2());
        
        pool.shutdown();
        try{
            pool.awaitTermination(10,TimeUnit.HOURS);
        }
        catch(InterruptedException e){}
    }
}
