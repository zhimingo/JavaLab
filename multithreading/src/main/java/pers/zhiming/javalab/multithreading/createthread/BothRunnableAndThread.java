package pers.zhiming.javalab.multithreading.createthread;

/**
 * 同时使用Runnable方式以及Thread方式
 * Thread重写run()不会执行Runnable的run()
 */
public class BothRunnableAndThread {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("我来自Runnable")) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
