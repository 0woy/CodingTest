package LinkedList;

import java.util.*;

/*
Design a data structure
that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache.
If the number of keys exceeds the capacity from this operation,
evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache {
    Map<Integer, Integer> map;
    int max;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
      return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class N_146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }


}
