package tree;

/**
 * @author FogHorn Systems, Inc.
 */
public class BinarySearchTress {

    private static boolean isBST(Node<Integer> root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(Node<Integer> root, Integer min, Integer max) {
        if(root == null)
            return true;

        if((min != null && root.getVal() <= min) ||
            (max != null && root.getVal() > max)) {
            return false;
        }

        return isBST(root.getL(), min, root.getVal()) && isBST(root.getR(), root.getVal(), max);
    }

    public static void main(String[] args) {
        Node<Integer> r = new Node<>(5);
        Node<Integer> r_l = new Node<>(3);
        Node<Integer> r_r = new Node<>(6);
        r.left(r_l).right(r_r);

        Node<Integer> r_l_l = new Node<>(2);
        Node<Integer> r_l_r = new Node<>(4);
        r_l.left(r_l_l).right(r_l_r);

        System.out.println(isBST(r));

        Node<Integer> r_l_l_l = new Node<>(7);
        r_l_l.left(r_l_l_l);

        System.out.println(isBST(r));
    }

}
