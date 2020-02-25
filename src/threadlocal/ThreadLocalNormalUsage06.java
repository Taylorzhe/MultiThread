package threadlocal;

import java.util.Collections;

/**
 * 描述：演示ThreadLocal用法2：避免传递参数的麻烦
 */
public class ThreadLocalNormalUsage06 {

    public static void main(String[] args) {
        new Service1().process();
    }
}


class Service1{

    public void process(){
        User user = new User("无敌");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2{

    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名:" + user.name);
        UserContextHolder.holder.remove();
        UserContextHolder.holder.set(new User("无敌死了"));
        new Service3().process();
    }
}

class Service3{

    public void process(){
        User user = UserContextHolder.holder.get();
        UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名:" + user.name);
    }
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }

}

class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}