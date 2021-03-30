package structure;

import java.util.LinkedHashMap;

public class LRUCache2<K, V> {
    int cacheSize;
    LinkedHashMap<K,V> map = new LinkedHashMap<>();
    public LRUCache2(int capacity){
        cacheSize = capacity;
    }

    public  V get(K key){
        if(!map.containsKey(key)){
            return null;
        }
        V ret = map.get(key);
        map.remove(key);
        map.put(key, ret);
        return ret;
    }

    public void put(K key, V val){
        if(key == null || val == null){
            return;
        }
        map.remove(key);
        map.put(key, val);
        if(map.size() > cacheSize){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
