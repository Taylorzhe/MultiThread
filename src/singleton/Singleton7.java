package singleton;

/**
 * 描述：静态内部类方式，推荐用
 */
public class Singleton7 {

    private Singleton7(){

    }

    private static class SingletonInstance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    public synchronized static Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
