package pers.zhiming.javalab.multithreading.stopthread;

/**
 * 最佳实践：catch了InterruptedException之后的优先选择：在方法
 * 签名中抛出异常，那么在run()就会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("save log");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
}
