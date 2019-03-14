package model;

import database.IDataBase;
import exception.NoElementInCache;

import java.util.*;

public abstract class Cache<K, V> {
    private Map<K, V> cache;
    private Queue<Pair<K, Long>> queue;
    private int capacity;
    protected IDataBase database;

    public Cache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.queue = new PriorityQueue<Pair<K, Long>>();
        this.capacity = capacity;
    }

    public K getKey(K key) throws NoElementInCache {
        if (cache.containsKey(key)) {
            return key;
        } else {
            throw new NoElementInCache();
        }
    }

    public V getData(K key) throws NoElementInCache {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            throw new NoElementInCache();
    }

    public void setElement(K key, V value) {
        cache.put(key, value);
        queue.add(new Pair(key, System.currentTimeMillis()));
        addElementInBD(key, value);
    }

    public void removeOldElemKey() {
        cache.remove(findOldestElemKey());
        deleteElementFromBD(findOldestElemKey());
        getQueue().remove();

    }

    public K findOldestElemKey() {
        return queue.peek().getKey();
    }

    public void addElementInBD(K key, V value){
        database.add(key, value);
    }

    public void deleteElementFromBD(K key){
        database.deleteOldest(key);
    }

    public void getElementFromBD(K key){
        database.get(key);
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

    public Queue<Pair<K, Long>> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Pair<K, Long>> queue) {
        this.queue = queue;
    }
}
