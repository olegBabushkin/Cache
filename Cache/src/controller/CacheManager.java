package controller;

import model.CacheL1;
import model.CacheL2;
import strategy.IStrategy;

public class CacheManager<K,V> implements ICache<K,V> {
    private CacheL1 cache1;
    private CacheL2 cache2;
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
    public V get(K date) {
        if (cache1.getData(date).equals("element not found"))
            return (V) cache2.getData(date); //!!!!!!
        else
            return (V) cache1.getData(date);
    }

    @Override
    public String toString() {
        return "controller.CacheManager{" +
                "cache1=" + cache1 +
                ", cache2=" + cache2 +
                '}';
    }

}
