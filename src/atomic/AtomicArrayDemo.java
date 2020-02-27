package atomic;


import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 描述：演示原子数组的使用方法
 */
public class AtomicArrayDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrement decrement = new Decrement(atomicIntegerArray);

        Thread[] threadsIncrementer = new Thread[100];
        Thread[] threadDecrement = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threadDecrement[i] = new Thread(decrement);
            threadsIncrementer[i] = new Thread(incrementer);
            threadsIncrementer[i].start();
            threadDecrement[i].start();
        }
        for (int i = 0; i < 100; i++) {
            threadDecrement[i].join();
            threadsIncrementer[i].join();
        }

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            if (atomicIntegerArray.get(i) != 0){
                System.out.println("发现了错误" + i);
            }

        }
        System.out.println("运行结束");
    }
}

class Decrement implements Runnable{
    private AtomicIntegerArray array;

    public Decrement(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Incrementer implements Runnable{
    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}