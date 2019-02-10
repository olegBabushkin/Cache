public class StrategyLRR2 implements IStrategy {
    @Override
    public void extrusion(String element, CacheL1 cacheL1, CacheL2 cacheL2) {
        if (!cacheL1.isFull()) {
            cacheL1.setElement(element);
        } else {
            cacheL2.setElement(cacheL1.findOldestElem());
            cacheL1.removeOldElement();
            cacheL1.setElement(element);
        }
    }
}

