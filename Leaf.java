public class Leaf<K, V> {
    private K key;
    private V value;
    private Leaf<K, V> left, right;

    public Leaf(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Leaf() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Leaf<K, V> getLeft() {
        return left;
    }

    public void setLeft(Leaf<K, V> left) {
        this.left = left;
    }

    public Leaf<K, V> getRight() {
        return right;
    }

    public void setRight(Leaf<K, V> right) {
        this.right = right;
    }
}
