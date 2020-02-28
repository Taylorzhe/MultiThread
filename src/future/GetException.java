package future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 描述：演示get方法过程中抛出异常，for循环为了演示抛出Exception的时机：
 * 并不是说一产生异常就抛出，直到我们get执行时，才会抛出
 */
public class GetException {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        Future<Integer> future = service.submit(new CallableTask());
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(500);
            }
            System.out.println(future.isDone());
            future.get();
        } catch (InterruptedException e) {
            System.out.println("抛出InterruptedException异常");
        } catch (ExecutionException e) {
            System.out.println("抛出ExecutionException异常");
        }
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            throw new IllegalArgumentException("Callable抛出异常");
        }
    }
}
