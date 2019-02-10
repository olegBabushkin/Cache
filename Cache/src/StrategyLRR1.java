
public class StrategyLRR1 implements IStrategy {

    CacheL1 cacheL1;
    CacheL2 cacheL2;


    @Override
    public void extrusion(String element, CacheL1 cacheL1, CacheL2 cacheL2) {
        this.cacheL1 = cacheL1;
        this.cacheL2 = cacheL2;
        setElementInclusiveDE(element);
    }

    public void extrusionCacheisFull(String element) {
        cacheL2.removeOldElement();
        extrusionCacheisNotFull(element);
    }

    public void extrusionCacheisNotFull(String element) {
        cacheL2.setElement(element);
        if ((!cacheL1.isFull()))
            cacheL1.setElement(element);
        else {
            cacheL1.removeOldElement();
            cacheL1.setElement(element);
        }
    }
    public void setElementInclusiveDE(String element) {
        if (!cacheL2.isFull()) {
            extrusionCacheisNotFull(element);
        } else {
            extrusionCacheisFull(element);
        }
    }
}
