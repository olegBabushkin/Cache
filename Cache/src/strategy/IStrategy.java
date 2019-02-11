package strategy;

import model.CacheL1;
import model.CacheL2;

public interface IStrategy {
    void extrusion(String key, Object value, CacheL1 cacheL1, CacheL2 cacheL2);
}
