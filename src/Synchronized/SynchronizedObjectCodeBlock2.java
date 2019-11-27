package Synchronized;

/**
 * 对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{

    static SynchronizedObjectCodeBlock2 instance1 = new SynchronizedObjectCodeBlock2();
    static SynchronizedObjectCodeBlock2 instance2 = new SynchronizedObjectCodeBlock2();
    Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是对象锁的代码块形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

    }
}
