package controller;

import exception.NoElementInCache;
import model.CacheL1;
import model.CacheL2;
import strategy.IStrategy;

import java.util.NoSuchElementException;

public class CacheManager<K, V> implements ICache<K, V> {
    private CacheL1<K, V> cache1;
    private CacheL2<K, V> cache2;
    private IStrategy strategy;

    public CacheManager(IStrategy strategy, CacheL1 L1, CacheL2 L2) {
        this.strategy = strategy;
        this.cache1 = L1;
        this.cache2 = L2;
    }

    public CacheManager(IStrategy strategy) {
        this.strategy = strategy;
        this.cache1 = new CacheL1(10);
        this.cache2 = new CacheL2(10);
    }

    @Override
    public void put(K key, V value) {
        strategy.extrusion(key, value, cache1, cache2);
    }

    @Override
    public V get(K key) throws NoElementInCache {
        try {
            return cache1.getData(key);
        } catch (NoElementInCache c) {
            try {
                return cache2.getData(key);
            } catch (NoElementInCache e) {
                throw new NoElementInCache("not element in both caches");
            }
        }
    }

    @Override
    public String toString() {
        return "controller.CacheManager{" +
                "cache1=" + cache1 +
                ", cache2=" + cache2 +
                '}';
    }

}
