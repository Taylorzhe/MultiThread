package threadobjectclasscommonmethods;

/**
 * 描述：两个线程交替打印0-100的奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEveWait {
    public static int num = 0;
    static Object object = new Object();

    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (object) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        TurningRunner runnable = new TurningRunner();
        Thread odd = new Thread(runnable, "偶数");
        Thread even = new Thread(runnable, "奇数");
        odd.start();
        even.start();
    }
}
