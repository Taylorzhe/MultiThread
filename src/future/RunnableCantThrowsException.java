package future;

/**
 * 描述：在Runnable的run方法中无法抛出checked Exception
 */
public class RunnableCantThrowsException {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
