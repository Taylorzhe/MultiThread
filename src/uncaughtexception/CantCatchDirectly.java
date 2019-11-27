package uncaughtexception;

/**
 * 描述：不加try/catch 抛出4个异常，都带线程名字
 * 加了try/catch，期望捕获到第一个线程的异常，线程234不应该运行，希望打印出Caught Exception
 * 执行时发现，根本没有Caught Exception，线程234依然运行并且抛出异常
 */
public class CantCatchDirectly implements Runnable{
    public static void main(String[] args) throws InterruptedException {

            new Thread(new CantCatchDirectly(), "MyThread1").start();
            new Thread(new CantCatchDirectly(), "MyThread2").start();
            new Thread(new CantCatchDirectly(), "MyThread3").start();
            new Thread(new CantCatchDirectly(), "MyThread4").start();

        Thread.sleep(300);
    }


    @Override
    public void run() {
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("Caught Exception");
        }

    }
}
