package pers.zhiming.javalab.multithreading.stopthread.volatiledemo;

import java.util.concurrent.BlockingDeque;

/**
 * 演示用volatile的局限
 * 陷入阻塞时，volatile是无法停止线程的
 */
public class WrongWayVolatileCannotStop {

}

class Producer implements Runnable {

    BlockingDeque storage;

    public Producer(BlockingDeque storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

    }
}
