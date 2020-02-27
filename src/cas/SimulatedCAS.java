package cas;

/**
 * 描述：模拟CAS操作，等价代码
 */
public class SimulatedCAS {

    private int value;
    public synchronized int comparedAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

}
