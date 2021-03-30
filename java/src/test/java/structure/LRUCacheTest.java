package structure;

import junit.framework.TestCase;

public class LRUCacheTest extends TestCase {

    public void testRemoveEldestEntry() {
        LRUCache<Integer, Integer> util = new LRUCache<>(3);
        util.put(3, 1);
        util.put(2, 2);
        util.put(1, 3);
        System.out.println(util.get(3));
        util.put(4,5);
        System.out.println(util.getOrDefault(3, -1));
    }
}