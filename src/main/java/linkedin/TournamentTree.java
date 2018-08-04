package linkedin;

import tree.Node;

/**
 * LinkedIn
 * https://www.careercup.com/question?id=5196022759292928
 *
 * A tournament tree is a binary tree where the parent is the min of the 2 children.
 * Given a tournament tree, find the 2nd min value in the tree. A node in the tree
 * will always have 2 or 0 children. Also all leaves will have distinct and unique values.
 */
public class TournamentTree {

    private Integer secondMin(Node<Integer> root) {
        if(root.getL() == null && root.getR() == null) {
            return Integer.MAX_VALUE;
        }

        Node<Integer> next;
        int min;

        if(root.getVal() == root.getL().getVal()) {
            next = root.getL();
            min = root.getR().getVal();
        } else {
            next = root.getR();
            min = root.getL().getVal();
        }

        return Math.min(min, secondMin(next));
    }


    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(2);
        Node<Integer> n6 = new Node<>(5);
        Node<Integer> n7 = new Node<>(3);

        n1.left(n2).right(n3);
        n2.left(n4).right(n5);
        n3.left(n6).right(n7);

        TournamentTree tournamentTree = new TournamentTree();
        System.out.println("Second largest = " + tournamentTree.secondMin(n1));
    }

}
