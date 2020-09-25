package simple;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxQueueTest extends TestCase {
    MaxQueue queue;
    @BeforeClass
    public void init(){
        queue = new MaxQueue();
    }
    @Test
    public void test(){
        queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        int max = queue.max_value();
        queue.pop_front();
        max = queue.max_value();

    }


}