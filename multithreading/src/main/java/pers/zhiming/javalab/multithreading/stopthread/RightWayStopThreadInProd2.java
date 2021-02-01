package pers.zhiming.javalab.multithreading.stopthread;

/**
 * 最佳实践：在catch子语句中调用Thread.currentThread().interrupt()来
 * 恢复设置中断状态，以便在后续的执行中，依然能够检查到刚才发生了中断
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted, 程序运行结束");
                break;
            }
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
