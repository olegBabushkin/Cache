public class Tree<K, V> {
    Leaf<K, V> root;

    public Tree() {
    }

    public void addRoot(K key, V value) {
        Leaf<K, V> root = new Leaf<>(key, value);
        this.root = root;
        root.setLeft(null);
        root.setLeft(null);
    }
}
