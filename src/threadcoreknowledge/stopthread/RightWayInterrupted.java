package threadcoreknowledge.stopthread;

/**
 * 注意：Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 */
public class RightWayInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        };
        Thread threadOne = new Thread(runnable);
        threadOne.start();
        threadOne.interrupt();
        System.out.println("isInterrupted：" + threadOne.isInterrupted());
        System.out.println("isInterrupted：" + threadOne.interrupted());
        System.out.println("isInterrupted：" + Thread.interrupted());
        System.out.println("isInterrupted：" + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is Over");
    }

}
