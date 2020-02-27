package cas;

/**
 * 描述：模拟CAS操作，等价代码
 */
public class TwoThreadCompetition implements Runnable{

    private int value;
    public synchronized int comparedAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

    @Override
    public void run() {
        comparedAndSwap(0,1);
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadCompetition r = new TwoThreadCompetition();
        r.value = 0;
        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        t1.start();
        t2.start();
        t1.join();
        t1.join();
        System.out.println(r.value);
    }
}
