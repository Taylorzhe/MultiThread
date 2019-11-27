package threadobjectclasscommonmethods;

/**
 * 描述：先join再mainThread.getState()
 * 也可以通过debugger看线程join前后状态的对比
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(thread.getState());
                    System.out.println("Thread-0运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        thread1.join();
        System.out.println("子线程运行完毕");

    }
}
