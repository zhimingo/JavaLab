package pers.zhiming.javalab.multithreading.uncaughtexception;

/**
 * 1.不加try/catch 抛出四个异常，都带线程名字
 * 2.加了try/catch，期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3.执行时发现，根本没有Caught Exception,线程234依然运行并且抛出异常
 * 说明线程的异常不能用传统方法捕获
 *
 * 方案一：手动在每个run方法中进行try/catch（不推荐）
 * 方案二：利用UncaughtExceptionHandler
 */
public class CannotCatchDirectly implements Runnable {

    @Override
    public void run() {
//        throw new RuntimeException();
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Caught Exception");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CannotCatchDirectly(), "MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CannotCatchDirectly(), "MyThread-4").start();
        } catch (InterruptedException e) {
            System.out.println("Caught Exception");
        }
    }
}
