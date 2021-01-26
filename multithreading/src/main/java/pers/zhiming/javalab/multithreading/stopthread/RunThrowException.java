package pers.zhiming.javalab.multithreading.stopthread;

/**
 * run()无法抛出checked Exception,只能用try/catch
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //
            }
        });
    }
}
