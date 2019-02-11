package model;

import java.util.*;

public abstract class Cache {
    private Map<String, Object> cache;
    private Queue<Pair> queue;
    private int capacity;

    public Cache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.queue = new PriorityQueue<Pair>();
        this.capacity = capacity;
    }

    public String getKey(String key) {
        if (cache.containsKey(key)) {
            return key;
        } else {
            return "element not found";
        }
    }

    public Object getData(String key){
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return "element not found";
        }
    }

    public void setElement(String key, Object value) {
        cache.put(key, value);
        queue.add(new Pair(key, System.currentTimeMillis()));
    }

    public void removeOldElemKey() {
        cache.remove(findOldestElemKey());
        getQueue().remove();
    }

    public String findOldestElemKey() {
        return queue.peek().getKey();
    }

    public void clearCache() {
        cache.clear();
    }

    public Map<String, Object> getCache() {
        return cache;
    }

    public void setCache(Map<String, Object> cache) {
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
