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

        LRUCache2<Integer,Integer> cache2 = new LRUCache2<>(3);
        for(int i = 0; i < 3; i++){
            cache2.put(i,i);
        }
        cache2.put(4,1);
        System.out.println(cache2.get(0));

        LRUCache3 lruCache3 = new LRUCache3(3);
        for(int i = 0; i < 3; i++){
            lruCache3.put(i, i);
        }
        lruCache3.put(4,4);
        System.out.println(lruCache3.get(0));
    }
}