package uncaughtexception;

/**
 * 描述：使用刚才自己写的UncaughtExceptionHandler
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器"));
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread4").start();


    }


    @Override
    public void run() {
        throw new RuntimeException();
    }
}