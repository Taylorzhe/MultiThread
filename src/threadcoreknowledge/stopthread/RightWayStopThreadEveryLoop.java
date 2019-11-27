package threadcoreknowledge.stopthread;

/**
 * 如果在执行过程中，每次循环都会调用sleep或wait方法等，那么不需要每次迭代都检查是否已中断
 */
public class RightWayStopThreadEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num <= 10000){
                    if (num % 100 == 0){
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(1);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }


}
