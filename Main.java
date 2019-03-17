public class Main {
    public static void main(String[] args) {
        Tree<Integer, String> tree = new Tree();
        tree.add(new Data<Integer, String>(15));
        tree.add(new Data<Integer, String>(16));
        tree.add(new Data<Integer, String>(11));
        tree.add(new Data<Integer, String>(12));
        tree.add(new Data<Integer, String>(9, "asdv"));

        System.out.println(tree.min());
        System.out.println(tree.max());
        System.out.println(tree.findData(9));
        System.out.println(tree.findData(7));
        tree.rec(tree.getRoot());
        System.out.println();
        tree.recInversion(tree.getRoot());
    }
}
