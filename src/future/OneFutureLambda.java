package future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 描述：演示一个Future的使用方法
 */
public class OneFutureLambda {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = ()->{
            Thread.sleep(3000);
            return new Random().nextInt();
        };
        Future<Integer> future = service.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class CallableTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
