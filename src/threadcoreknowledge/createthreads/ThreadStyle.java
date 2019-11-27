package threadcoreknowledge.createthreads;

/**
 * 用继承Thread类实现线程
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new ThreadStyle();
        thread.start();
    }
}
