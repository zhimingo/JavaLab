package pers.zhiming.javalab.multithreading.createthread;

/**
 * 优先选择Runnable方式
 * 由于Java只能单继承，所以尽量选择Runnable的方式
 * 两种方式本质上都是运行run()方法
 * 用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
