package middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class RLEIterator_900Test {

    @Test
    public void next() {
        int a[] = {3, 8, 0, 9, 2, 5};
        RLEIterator_900 obj = new RLEIterator_900(a);
        int params[] = {2, 1, 1, 2};
        for(int val: params){
            System.out.println(obj.next(val));
        }
    }
}