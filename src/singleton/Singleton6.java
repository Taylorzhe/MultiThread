package singleton;

/**
 * 描述：双重检查（面试推荐）
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6(){

    }

    public synchronized static Singleton6 getInstance(){
        if (instance == null){
            synchronized (Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
