package controller;

//point of entry
public interface ICache <K,V> {
    void put (K key, V value);
    V get (K date);
}
