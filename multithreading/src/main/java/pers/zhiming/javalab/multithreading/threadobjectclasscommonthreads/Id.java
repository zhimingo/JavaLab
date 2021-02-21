package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

public class Id {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的id" + Thread.currentThread().getId());
        System.out.println("子线程的id" + thread.getId());
    }
}
