package model;

public class CacheL1 extends Cache {

    public CacheL1(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "model.CacheL1{" +
                "cache=" + super.getCache() +
                '}';
    }
}
