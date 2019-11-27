package sixstates;

/**
 * 展示线程的new、Runnable、terminated三种状态。
 * 即使时正在运行，也是Runnable状态
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Runnable状态，即使是正在运行，也是Runnable状态,而不是Running
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
