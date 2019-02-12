package strategy;

import model.CacheL1;
import model.CacheL2;

public class StrategyLRR1 implements IStrategy {

    CacheL1 cacheL1;
    CacheL2 cacheL2;


    @Override
    public void extrusion(Object key, Object value, CacheL1 cacheL1, CacheL2 cacheL2) {
        this.cacheL1 = cacheL1;
        this.cacheL2 = cacheL2;
        setElementInclusiveDE(key, value);
    }

    public void extrusionCacheisFull(Object key, Object value) {
        cacheL2.removeOldElemKey();
        extrusionCacheisNotFull(key, value);
    }

    public void extrusionCacheisNotFull(Object key, Object value) {
        cacheL2.setElement(key, value);
        if ((!cacheL1.isFull()))
            cacheL1.setElement(key, value);
        else {
            cacheL1.removeOldElemKey();
            cacheL1.setElement(key, value);
        }
    }
    public void setElementInclusiveDE(Object key, Object value) {
        if (!cacheL2.isFull()) {
            extrusionCacheisNotFull(key, value);
        } else {
            extrusionCacheisFull(key, value);
        }
    }
}
