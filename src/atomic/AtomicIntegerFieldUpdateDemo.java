package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 描述：演示AtomicIntegerFieldUpdate的用法
 */
public class AtomicIntegerFieldUpdateDemo implements Runnable{

    static Candidate tom;
    static Candidate peter;
    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdate
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdate.getAndIncrement(tom);
        }
    }

    public static class Candidate{
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdateDemo r = new AtomicIntegerFieldUpdateDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通的变量" + peter.score);
        System.out.println("升级后的结果" + tom.score);
    }
}
