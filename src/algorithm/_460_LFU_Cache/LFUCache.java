package algorithm._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    //用来记录当前元素出现的次数中最少的次数，主要到时用来删除需要失效的元素
    private int min;
    //容量
    private final int capacity;
    //关联key和value
    private final HashMap<Integer, Integer> keyToValue;
    //统计key的使用次数
    private final HashMap<Integer, Integer> keyToCount;
    //关联相应次数对应的集合，该集合是有顺序的
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;


    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        int count = keyToCount.get(key);
        //因为使用了，数量发生变化，所以要找到之前数量对应的集合，再删除该key
        countToLRUKeys.get(count).remove(key);
        //调整min的大小，让它为最小使用次数
        if (count == min && countToLRUKeys.get(count).size() == 0) {
            min++;
        }
        //重新设置该key的数量
        putCount(key, count + 1);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key);
            return;
        }
        //如果数量超过了容量，就要让最不常用的key失效
        if (keyToValue.size() >= capacity) {
            //通过min找到对应的集合，令第一个元素失效，因为第一个元素是最久未使用的
            evit(countToLRUKeys.get(min).iterator().next());
        }
        min = 1;
        putCount(key, min);
        keyToValue.put(key, value);
    }

    public void evit(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToValue.remove(key);
    }

    public void putCount(int key, int count) {
        keyToCount.put(key, count);
        //如果该key存在，就返回该key对应的集合。如果该key不存在，就将第一个参数作为key，第二个参数作为value存入map中
        countToLRUKeys.computeIfAbsent(count, set -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
}
