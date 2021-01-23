package pers.zhiming.javalab.multithreading.startthread;

/**
 * 对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        runnable.run();
        new Thread(runnable).start();
    }
}
