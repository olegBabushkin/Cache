package controller;

//point of entry
public interface ICache {
    void put (String key, Object value);
    Object get (String date);
}
