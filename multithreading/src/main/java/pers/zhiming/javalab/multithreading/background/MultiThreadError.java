package pers.zhiming.javalab.multithreading.background;

import lombok.SneakyThrows;

/**
 * 演示死锁
 */
public class MultiThreadError implements Runnable {

    int flag = 1;

    static Object o1 = new Object();
    static Object o2 = new Object();

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1");
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadError r1 = new MultiThreadError();
        MultiThreadError r2 = new MultiThreadError();
        r1.flag = 1;
        r2.flag = 0;
        Thread threadA = new Thread(r1);
        Thread threadB = new Thread(r2);
        threadA.start();
        threadB.start();
    }
}
