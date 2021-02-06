package pers.zhiming.javalab.multithreading.threadobjectclasscommonthreads;

public class SleepDoNotReleaseMonitor implements Runnable {

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了monitor");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "释放了monitor");
    }

    public static void main(String[] args) {
        SleepDoNotReleaseMonitor sleepDoNotReleaseMonitor = new SleepDoNotReleaseMonitor();
        new Thread(sleepDoNotReleaseMonitor).start();
        new Thread(sleepDoNotReleaseMonitor).start();
    }
}
