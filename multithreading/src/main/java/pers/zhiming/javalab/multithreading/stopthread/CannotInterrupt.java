package pers.zhiming.javalab.multithreading.stopthread;

/**
 * 如果while里面放try/catch，会导致中断失效
 * sleep函数会清除中断的标志位
 */
public class CannotInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
          int num = 0;
          // 加上 !Thread.currentThread().isInterrupted() 判断也无效
          while (num <= 10000) {
              if (num % 100 == 0) {
                  System.out.println(num + "是100的倍数");
              }
              num++;
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
