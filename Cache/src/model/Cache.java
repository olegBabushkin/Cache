package model;

import java.util.*;

public abstract class Cache<K, V> {
    private Map<K, V> cache;
    private Queue<Pair> queue;
    private int capacity;

    public Cache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.queue = new PriorityQueue<Pair>();
        this.capacity = capacity;
    }

    public K getKey(K key) {
        if (cache.containsKey(key)) {
            return key;
        } else
            return (K) "not found";
    }

    public V getData(K key) {
        if (cache.containsKey(key)) {
            return (V) cache.get(key);
        } else
            return (V) "not found";
    }

    public void setElement(K key, V value) {
        cache.put(key, value);
        queue.add(new Pair(key, System.currentTimeMillis()));
    }

    public void removeOldElemKey() {
        cache.remove(findOldestElemKey());
        getQueue().remove();
    }

    public Object findOldestElemKey() {            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return queue.peek().getKey();
    }

    public void clearCache() {
        cache.clear();
    }

    public Map<K, V> getCache() {
        return cache;
    }

    public void setCache(Map<K, V> cache) {
        this.cache = cache;
    }

    public boolean isFull() {
        return this.capacity == cache.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Queue<Pair> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Pair> queue) {
        this.queue = queue;
    }
}
