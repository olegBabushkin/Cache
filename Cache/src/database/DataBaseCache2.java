package database;

//REDDIS
public class DataBaseCache2<K,V> implements IDataBase<K,V> {
    private static DataBaseCache2 instance;

    private DataBaseCache2() {
    }

    public static DataBaseCache2 getDataBase2(){
        if(instance==null){
            instance = new DataBaseCache2();
        }
        return instance;
    }

    @Override
    public void add(K key, V value) {
//addInReddis
        System.out.println("addInReddis");
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public void deleteOldest(K key) {

    }

    @Override
    public V get(K key) {
        return null;
    }
}
