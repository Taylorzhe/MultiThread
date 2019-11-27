package deadlock;

import java.util.Map;

/**
 * 描述：演示哲学家就餐问题导致的死锁
 */
public class DiningPhilosophers {
    public static class Philosopher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    doAction("Thinking");
                    synchronized (leftChopstick) {
                        doAction("Picked up left chopstick;");
                        synchronized (rightChopstick) {
                            doAction("Picked up right chopstick;");
                            doAction("put down right chopsticks");
                        }
                        doAction("put down right chopsticks");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "" + action);
        Thread.sleep((long) Math.random() * 10);
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[philosophers.length];
        for (int i=0; i<chopsticks.length; i++){
            chopsticks[i] = new Object();
        }
        for (int i=0; i<philosophers.length; i++) {
            Object leftChopsticks = chopsticks[i];
            Object rightChopsticks = chopsticks[(i + 1) % chopsticks.length];
            philosophers[i] = new Philosopher(leftChopsticks, rightChopsticks);
            new Thread(philosophers[i], "哲学家"+(i+1)+"号").start();
        }

    }
}
