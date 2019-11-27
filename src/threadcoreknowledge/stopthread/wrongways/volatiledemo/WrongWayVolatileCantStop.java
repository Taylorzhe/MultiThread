package threadcoreknowledge.stopthread.wrongways.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 当陷入阻塞时，volatile是无法停止线程的
 * 此例中，生产者的生产速度很快，消费者消费速度慢，所以就会出现阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {
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
        producer1.canceled = true;
        System.out.println(producer1.canceled);
    }
}

class Producer implements Runnable{
    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled){
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

class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if (Math.random() > 0.95){
            return false;
        }
        return true;
    }
}
