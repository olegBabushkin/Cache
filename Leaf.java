public class Leaf<K extends Comparable<K>,V> {
    private Data<K,V> data;
    Leaf left, right;

    public Leaf(Data<K,V> data) {
        this.data = data;
    }

    public Leaf() {
    }

    public Data<K,V> getData() {
        return data;
    }

    public void setData(Data<K,V> data) {
        this.data = data;
    }

    public Leaf getLeft() {
        return left;
    }

    public void setLeft(Leaf left) {
        this.left = left;
    }

    public Leaf getRight() {
        return right;
    }

    public void setRight(Leaf right) {
        this.right = right;
    }
}
