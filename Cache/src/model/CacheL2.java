package model;

import database.DataBaseCache2;

public class CacheL2<K,V> extends Cache<K,V> {

    public CacheL2(int capacity) {
        super(capacity);
        super.database = DataBaseCache2.getDataBase2();
    }

    @Override
    public String toString() {
        return "model.CacheL2{" +
                "cache=" + super.getCache() +
                '}';
    }
}

