package immutable;

/**
 * 描述：
 */
public class FinalStringDemo1 {
    public static void main(String[] args) {
        String a = "wukong2";
        final String b = "wukong";
        String c = b + 2;
        String d = "wukong";
        String e = d + 2;
        System.out.println(a == c);
        System.out.println(a == e);
    }
}
