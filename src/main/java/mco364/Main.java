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

class MyTask implements Runnable // option 2
{
    @Override
    public void run(){       
        System.out.println("Started " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        System.out.println("Completed " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        
        //Thread t = new Thread(new MyTask( ));
        
        //t.run(); // runs on Main thread that runs program not a NEW hthread
        
        //t.start(); // new Thread
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        for (int i=0;i<10;i++)
            pool.execute(new MyTask());

        pool.shutdown();
        try{
            pool.awaitTermination(1,TimeUnit.HOURS);
        }
        catch(InterruptedException e){}
        
        System.out.println("Hooray!!");
    }
}
