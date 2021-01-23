package pers.zhiming.javalab.multithreading.startthread;

/**
 * 演示不能两次调用start方法，否则会报错
 */
public class CannotStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
