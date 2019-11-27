package Synchronized;

/**
 * 可重入粒度测试，调用父类方法
 */
public class SynchronizedSuperClass12 {
    public synchronized void doSomething(){
        System.out.println("我是父类方法");
    }
}
class Test extends SynchronizedSuperClass12{

    public synchronized void doSomething(){
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        Test ts = new Test();
        ts.doSomething();
    }
}
