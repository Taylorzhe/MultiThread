package Synchronized;

/**
 * 可重入粒度测试2:调用类内部另外的方法
 */
public class SynchronizedOtherMethod11 {
    int a = 0;

    public static void main(String[] args) {
        SynchronizedOtherMethod11 synchronizedOtherMethod11 = new SynchronizedOtherMethod11();
        synchronizedOtherMethod11.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1，a=" + a);
        if (a == 0) {
            a++;
            method2();
        }
    }

    private synchronized void method2() {
        System.out.println("这是method2，a=" + a);
    }


}
