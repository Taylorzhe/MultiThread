package threadlocal;

/**
 * 描述：
 */
public class ThreadLocalNPE {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
    }

    public Long get(){
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        System.out.println(threadLocalNPE.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalNPE.set();
                System.out.println(threadLocalNPE.get());
            }
        }).start();
        threadLocalNPE.set();
        System.out.println(threadLocalNPE.get());
    }
}
