package database;

public interface IDataBase <K,V> {
    public void add(K key, V value);
    public void deleteOldest(K key);
    public V get(K key);
}
