package structure;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap {
    int cacheSize;

    public LRUCache(int size){
        cacheSize = size;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }
}
