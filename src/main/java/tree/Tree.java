package tree;

import java.util.LinkedList;

/**
 * @author FogHorn Systems, Inc.
 */
public class Tree {

    private Node<Integer> root = null;

    public void add(int val) {
        root = addRecursive(val, root);
    }

    private Node<Integer> addRecursive(int val, Node<Integer> current) {
        if(current == null) {
            return new Node<>(val);
        }

        if(val < current.getVal()) {
            current.left(addRecursive(val, current.getL()));
        } else if(val > current.getVal()) {
            current.right(addRecursive(val, current.getR()));
        } else {
            return current;
        }

        return current;
    }

    private void printLevelByLevel() {
        if(root == null) return;

        LinkedList<Node<Integer>> list = new LinkedList<>();
        list.add(root);

        LinkedList<Node<Integer>> next = new LinkedList<>();
        while (!list.isEmpty()) {
            Node<Integer> cur = list.removeFirst();
            if(cur.getL() != null) next.add(cur.getL());
            if(cur.getR() != null) next.add(cur.getR());
            System.out.print(cur.getVal() + " ");
            if(list.isEmpty()) {
                list.addAll(next);
                next.clear();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(6);
        tree.add(4);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(9);

        tree.printLevelByLevel();
    }

}
