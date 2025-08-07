package structure;

import junit.framework.TestCase;
import org.junit.Assert;

public class LRUCache3Test extends TestCase {

    public void testLruCache(){
        LRUCache3<Integer, Integer> cache = new LRUCache3<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, (int)cache.get(1));
        cache.put(3, 3);
        Assert.assertNull(cache.get(2));
        cache.put(4, 4);
        Assert.assertNull(cache.get(1));
        Assert.assertEquals(3, (int)cache.get(3));
        Assert.assertEquals(4, (int)cache.get(4));
    }

}