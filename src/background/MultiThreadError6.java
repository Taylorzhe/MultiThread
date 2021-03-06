package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 */
public class MultiThreadError6 {
    private Map<String, String> states;

    public MultiThreadError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周四");
            }
        }).start();

    }

    public Map<String, String> getStates(){
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadError6 multiThreadError6 = new MultiThreadError6();
        Thread.sleep(1000);
        System.out.println(multiThreadError6.getStates().get("1"));
    }
}
