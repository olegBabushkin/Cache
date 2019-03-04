package database;

import java.sql.*;

public class DataBaseCache1<K, V> implements IDataBase<K, V> {
    private static DataBaseCache1 instance;
    private Connection connect;

    private DataBaseCache1() {
       //PoolExecuteConnection
    }

    public static DataBaseCache1 getDataBase1() {
        if (instance == null) {
            instance = new DataBaseCache1();
        }
        return instance;
    }

    @Override
    public void add(K key, V value) {
        try (Connection connect = DriverManager.getConnection("jdbc:postgresql:cache", "ishop", "pass")) {
            try (PreparedStatement ps = connect.prepareStatement("insert into cache (key, value) VALUES (?,?)")) {
                //create table CACHE (key VARCHAR (30) PRIMARY KEY NOT NULL, value INTEGER);
                ps.setObject(1,key);
                ps.setObject(2,value);
                ps.executeUpdate();
                System.out.println("addInDB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public void deleteOldest(K key) {
        try (Connection connect = DriverManager.getConnection("jdbc:postgresql:cache", "ishop", "pass")) {
            try (PreparedStatement ps = connect.prepareStatement("delete from cache where key = ?")) {
                //check;
                ps.setObject(1,key);
                ps.executeUpdate();
                System.out.println("deleteFromDB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public V get(K key) {
        V res = null;
        try (Connection connect = DriverManager.getConnection("jdbc:postgresql:cache", "ishop", "pass")) {
            try (PreparedStatement ps = connect.prepareStatement("select value from cache where key = ?")) {
                //create table CACHE (key VARCHAR (30) PRIMARY KEY NOT NULL, value INTEGER);
                ps.setObject(1,key);
                ResultSet rs = ps.executeQuery();
                res = (V)rs.getObject("value");
                System.out.println("getFromDB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
