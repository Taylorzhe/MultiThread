package threadcoreknowledge.stopthread.wrongways.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用中断来修复刚才的无尽等待问题
 */
public class WrongWayVolatileFixed {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(10);
        Producer1 producer1 = new Producer1(storage);
        Thread producerThread = new Thread(producer1);
        producerThread.start();
        Thread.sleep(1000);

        Consumer1 consumer1 = new Consumer1(storage);
        while (consumer1.needMoreNums()){
            System.out.println(consumer1.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多的数据了");
        //一旦消费者不需要更多数据了，我们应该让生产者也停下来，但实际情况
        producerThread.interrupt();
    }
}

class Producer1 implements Runnable{
    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer1(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !Thread.currentThread().isInterrupted()){
                if (num % 100 == 0){
                    storage.put(num);
                    System.out.println(num + "是100的倍数,被放到仓库中了。");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者结束运行");
        }
    }
}

class Consumer1 {
    BlockingQueue storage;

    public Consumer1(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if (Math.random() > 0.95){
            return false;
        }
        return true;
    }
}
