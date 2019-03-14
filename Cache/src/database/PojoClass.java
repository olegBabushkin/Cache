package database;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "cache")
public class PojoClass<K,V> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;
    @Column(name="key")
    @Type(type = "string")
    private K key;
    @Column(name="value")
    @Type(type = "int")
    private V value;

    public PojoClass() {
    }

    public PojoClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
