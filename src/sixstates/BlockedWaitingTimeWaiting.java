package sixstates;

/**
 * 展示Blocked，Waiting，TimeWaiting三种状态
 */
public class BlockedWaitingTimeWaiting implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimeWaiting runnable = new BlockedWaitingTimeWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread1.join(1000);
        System.out.println(thread1.getState()+"1");
        //答应Blocked状态，因为Thread2想拿到syn（）所持有的锁却拿不到
        System.out.println(thread2.getState()+"2");
//        Thread.sleep(3000);
//        System.out.println(thread1.getState()+"3");
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        try {
           Thread.sleep(10000);
//           wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
