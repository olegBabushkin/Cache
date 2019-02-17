public class Tree<K extends Comparable<K>, V> {
    private Leaf<K, V> root;

    public Tree() {
    }

    public Leaf getRoot(){
        return root;
    }

    public Data<K, V> min() {

        Leaf current = root;
        Leaf parent = null;
        while (current != null) {
            parent = current;
            current = current.getLeft();
        }
        return parent.getData();

    }

    public Data<K, V> max() {

        Leaf current = root;
        Leaf parent = null;
        while (current != null) {
            parent = current;
            current = current.getRight();
        }
        return parent.getData();

    }

    public Data<K, V> findData(K key) {
        if (root != null) {
            Leaf<K, V> current = root;
            while ((current.getData().getKey() != key)) {
                if (current.getData().getKey().compareTo(key) == 1) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
                if (current == null) {
                    return null;
                }
            }
            return current.getData();
        }
        return null;
    }


    public void add(Data<K, V> data) {
        Leaf<K, V> leaf = new Leaf<>(data);
        if (this.root == null) {
            this.root = leaf;
        } else {
            Leaf current = root;
            Leaf parent;
            while (true) {
                parent = current;
                if (current.getData().compareTo(data) == 1) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.left = leaf;
                        return;
                    }
                } else {
                    if (current.getData().compareTo(data) == -1) {
                        current = current.getRight();
                        if (current == null) {
                            parent.right = leaf;
                            return;
                        }
                    }
                }
            }
        }
    }

    public void rec(Leaf root){
        if (root!= null){
            rec(root.left);
            System.out.println(root.getData());
            rec(root.right);
        }
    }

    public void recInversion(Leaf root){
        if (root!= null){
            Leaf temp = root.left;
            root.left=root.right;
            root.right = temp;
            recInversion(root.left);
            System.out.println(root.getData());
            recInversion(root.right);
        }
    }
}

