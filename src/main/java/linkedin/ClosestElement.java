package linkedin;

import tree.Node;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * https://www.programcreek.com/2014/05/leetcode-closest-binary-search-tree-value-java/
 */
public class ClosestElement {
    private Integer closest;

    private Integer findClosest(Node<Integer> root, int k) {
        closest = null;
        helper(root, k);
        return closest;
    }

    private void helper(Node<Integer> root, int k) {
        if(root == null) {
            return;
        }

        int currentVal = root.getVal();
        if(closest == null || (Math.abs(currentVal - k) < Math.abs(closest - k))) {
            closest = currentVal;
        }

        if(k < root.getVal()) {
            helper(root.getL(), k);
        } else {
            helper(root.getR(), k);
        }
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(9);
        Node<Integer> n2 = new Node<>(4);
        Node<Integer> n3 = new Node<>(17);
        Node<Integer> n4 = new Node<>(3);
        Node<Integer> n5 = new Node<>(6);
        Node<Integer> n6 = new Node<>(22);
        Node<Integer> n7 = new Node<>(5);
        Node<Integer> n8 = new Node<>(7);
        Node<Integer> n9 = new Node<>(20);

        n1.left(n2).right(n3);
        n2.left(n4).right(n5);
        n5.left(n7).right(n8);
        n3.right(n6);
        n6.left(n9);

        ClosestElement closestElement = new ClosestElement();

        System.out.println("Closest Node to 4 : " + closestElement.findClosest(n1, 4));
        System.out.println("Closest Node to 18 : " + closestElement.findClosest(n1, 18));
        System.out.println("Closest Node to 7 : " + closestElement.findClosest(n1, 7));
        System.out.println("Closest Node to 21 : " + closestElement.findClosest(n1, 21));
    }

}
