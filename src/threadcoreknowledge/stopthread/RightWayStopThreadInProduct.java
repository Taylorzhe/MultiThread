package threadcoreknowledge.stopthread;

/**
 * 最佳时间catch了InterruptedException之后选择：在方法签名中抛出异常
 * 那么在run（）就会强制try/catch
 */
public class RightWayStopThreadInProduct implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduct());
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }
}
