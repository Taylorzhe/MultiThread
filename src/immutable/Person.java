package immutable;

/**
 * 描述：不可变的对象，演示其他类无法修改这个对象，public也不行
 */
public class Person {
    private final int age = 18;
    private final String name = "Alice";
    int score = 0;
}
