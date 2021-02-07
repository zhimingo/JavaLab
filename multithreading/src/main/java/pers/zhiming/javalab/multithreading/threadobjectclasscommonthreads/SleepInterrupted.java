package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Thread.Sleep();
 * TimeUnit.SECONDS.sleep()
 * TimeUnit这种方法比Thread.sleep更佳
 */
public class SleepInterrupted implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                // TimeUnit.HOURS.sleep(3);
                // TimeUnit.MINUTES.sleep(25);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }
        }
    }
}
