package threadpool;

/**
 * 描述：
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        for (int i = 0; i < 10; i++) {
            thread.run();
        }
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("创建了一个线程");
        }
    }
}
