package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：volatile不适用的情况2
 */
public class NoVolatile2 implements Runnable{
    volatile boolean done = false;
    AtomicInteger readA = new AtomicInteger();
    @Override
    public void run() {
        for (int i=0; i<10000; i++){
            flipDone();
            readA.incrementAndGet();
        }
    }

    private void flipDone() {
        done = !done;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new UseVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((UseVolatile) r).done);
        System.out.println(((UseVolatile) r).readA);
    }
}
