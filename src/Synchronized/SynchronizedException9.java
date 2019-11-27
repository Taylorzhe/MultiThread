package Synchronized;

/**
 * 方法抛出异常后，会释放锁。展示不抛出异常前和抛出异常后的对比：
 * 一旦抛出了异常，第二个线程就会立刻进入同步方法，意味着锁已经释放
 */

public class SynchronizedException9 implements Runnable{
    static SynchronizedException9 instance = new SynchronizedException9();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("运行结束");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else
            method2();
    }

    public synchronized void method1(){
        System.out.println("我是加锁的静态方法1。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            throw new Exception("异常抛出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是加锁的非静态方法2。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
