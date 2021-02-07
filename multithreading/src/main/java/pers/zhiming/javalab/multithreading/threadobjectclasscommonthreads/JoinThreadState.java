package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

import java.util.concurrent.TimeUnit;

/**
 * 先join再mainThread.getState()
 * 通过debugger看线程join前后的状态的对比
 */
public class JoinThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(mainThread.getState());
                System.out.println("Thread-0运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        System.out.println("等待子线程运行完毕");
        thread.join();
        System.out.println("等待子线程运行完毕");
    }
}
