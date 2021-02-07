package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

/**
 * 模拟join()原理
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Thread1 finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });

        thread.start();
        System.out.println("开始等待子线程执行完毕");
        // thread.join();
        // 调用任何对象的wait()方法会让当前线程进入等待
        // 此时主线程进入阻塞状态
        // thread执行完毕之后会调用notifyAll唤醒主线程
        synchronized (thread) {
            System.out.println(1111);
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
