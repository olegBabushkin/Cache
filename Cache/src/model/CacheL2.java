package model;

public class CacheL2 extends Cache {

    public CacheL2(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "model.CacheL2{" +
                "cache=" + super.getCache() +
                '}';
    }
}

