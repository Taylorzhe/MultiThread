package immutable;

/**
 * 描述：
 */
public class FinalStringDemo2 {

    public static void main(String[] args) {
        String a = "wukong2";
        //编译后不能确定b的值，得运行之后才能确定b的值，所以b会放在堆中
        final String b = getDashixiong();
        String c = b + 2;
        System.out.println(a == c);
    }

    private static String getDashixiong() {
        return "wukong";
    }
}
