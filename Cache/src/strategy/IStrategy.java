package strategy;

import model.CacheL1;
import model.CacheL2;

public interface IStrategy {
    void extrusion(Object key, Object value, CacheL1 cacheL1, CacheL2 cacheL2);
}
