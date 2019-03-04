package model;

import database.DataBaseCache1;

public class CacheL1<K, V> extends Cache<K, V> {

    public CacheL1(int capacity) {
        super(capacity);
        super.database = DataBaseCache1.getDataBase1();
    }

    @Override
    public String toString() {
        return "model.CacheL1{" +
                "cache=" + super.getCache() +
                '}';
    }
}
