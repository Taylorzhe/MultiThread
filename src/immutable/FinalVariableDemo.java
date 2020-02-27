package immutable;

/**
 * 描述：
 */
public class FinalVariableDemo {

    //第一种：直接赋值
    private final int a =10;

    //第二种：构造函数中赋值
//    public FinalVariableDemo(int a) {
//        this.a = a;
//    }

    //第三种：代码块赋值
//    {
//        a = 7;
//    }

    //第一种：直接赋值
    private static final int b = 7;

    //第二种：静态代码块赋值
//    static{
//        b = 10;
//    }

    void testFinal(){
        //必须在使用之前赋值
        final int c;
    }
}
