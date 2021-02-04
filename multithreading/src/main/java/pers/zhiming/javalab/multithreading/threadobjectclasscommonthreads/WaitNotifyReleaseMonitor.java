package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

/**
 * 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadA got resourceA lock.");
                synchronized (resourceB) {
                    System.out.println("ThreadA got resourceB lock.");
                    try {
                        resourceA.wait();
                        System.out.println("ThreadA releases resourceA lock.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA) {
                System.out.println("ThreadB got resourceA lock.");
                synchronized (resourceB) {
                    System.out.println("ThreadB got resourceB lock.");
                }
            }
        });

        threadA.start();
        threadB.start();

    }
}
