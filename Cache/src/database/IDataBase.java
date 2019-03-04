package database;

import java.sql.SQLException;

public interface IDataBase <K,V> {
    public void add(K key, V value);
    public void delete(K key);
    public void deleteOldest(K key);
    public V get(K key);
}
