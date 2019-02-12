package strategy;

import model.CacheL1;
import model.CacheL2;

public class StrategyLRR2 implements IStrategy {

    @Override
    //ExclusiveDE
    public void extrusion(Object key, Object value, CacheL1 cacheL1, CacheL2 cacheL2) {
        if (!cacheL1.isFull()) {
            cacheL1.setElement(key, value);
        } else {
            cacheL2.setElement(cacheL1.findOldestElemKey(), cacheL1.getData((cacheL1.findOldestElemKey())));
            cacheL1.removeOldElemKey();
            cacheL1.setElement(key, value);
        }
    }
}

