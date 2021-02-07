package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

import java.util.concurrent.TimeUnit;

/**
 * 演示join, 注意语句输出顺序，会变化
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                // Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });

        Thread thread2 = new Thread(() -> {
            try {
                // Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });

        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程执行完毕");
        thread1.join();
        //thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
