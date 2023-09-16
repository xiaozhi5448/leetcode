package design;

import junit.framework.TestCase;
import org.junit.Assert;

public class LRUCache2Test extends TestCase {

    LRUCache2<Integer> cache = new LRUCache2<Integer>(3);
    @Override
    protected void setUp() throws Exception {
        cache = new LRUCache2<Integer>(3);
        cache.put("1", 1);
        cache.put("2", 2);
    }


    public void testGet() {
        Integer i = cache.get("1");
        Assert.assertTrue(i.equals(1) );

    }

    public void testPut() {

    }

    public void testTestToString() {
        System.out.println(cache);
        cache.get("1");
        System.out.println(cache);
        cache.put("3", 3);
        System.out.println(cache);
        cache.put("3", 5);
        System.out.println(cache);
        cache.put("5", 5);
        System.out.println(cache);
    }
}