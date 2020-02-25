package threadpool;

import threadcoreknowledge.stopthread.wrongways.StopThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：演示内存溢出的情况(newFixedThreadPool出错的情况)
 */
public class FixedThreadPoolOOM {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}