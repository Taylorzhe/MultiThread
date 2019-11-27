package Synchronized;

public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }


//    @Override
//    public void run() {
//        synchronized (this){
//            for (int j=0; j<100000; j++){
//                i++;
//            }
//        }
//    }

//    @Override
//    public synchronized void run() {
//        for (int j=0; j<100000; j++){
//            i++;
//        }
//    }

//    @Override
//    public void run() {
//        synchronized (DisappearRequest1.class){
//            for (int j=0; j<100000; j++){
//                i++;
//            }
//        }
//    }

    @Override
    public void run() {
        method();
    }

    static synchronized void method(){
        for (int j=0; j<100000; j++){
            i++;
        }
    }
}
