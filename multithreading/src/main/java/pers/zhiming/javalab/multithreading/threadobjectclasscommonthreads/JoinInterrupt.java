package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

import java.util.concurrent.TimeUnit;

/**
 * join期间被中断的效果
 */
public class JoinInterrupt {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        Thread thread1 = new Thread(() -> {
            try {
                mainThread.interrupt();
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Thread1 finished.");
            } catch (InterruptedException e) {
                System.out.println("子线程中断完毕");
                e.printStackTrace();
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
            thread1.interrupt();
            e.printStackTrace();
        }
        System.out.println("子线程已经运行完毕");
    }
}
