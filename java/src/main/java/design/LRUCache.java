package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Integer capacity = 0;
    LinkedHashMap<Integer, Integer> container;
    public LRUCache(int capacity){
        this.capacity = capacity;
        container = new LinkedHashMap<Integer, Integer>(16, 0.5f, true);
    }
    public int get(int key) {
        return container.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(container.containsKey(key)){
            container.put(key, value);
        }else{
            if(container.size() >= capacity){
                Map.Entry<Integer, Integer> header = container.entrySet().iterator().next();
                container.remove(header.getKey());
            }
            container.put(key, value);
        }
    }
}
