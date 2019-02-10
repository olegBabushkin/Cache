import java.util.*;

public class CacheManager implements ICache {
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
    public void put(String element) {
        strategy.extrusion(element, cache1, cache2);
    }

    @Override
    public String get(String date) {
        return cache1.getElement(date);
    }

    @Override
    public String toString() {
        return "CacheManager{" +
                "cache1=" + cache1 +
                ", cache2=" + cache2 +
                '}';
    }
}
