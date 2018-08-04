package tree;

/**
 * @author FogHorn Systems, Inc.
 */
public class BinaryTree {

    private static <T> boolean isBalanced(Node<T> root, int balance) {
        if(root == null)
            return true;

        int diff = height(root.getL()) - height(root.getR());

        if(Math.abs(diff) > balance) {
            return false;
        }

        return isBalanced(root.getL(), balance) || isBalanced(root.getR(), balance);
    }

    private static <T> int height(Node<T> root) {
        if(root == null) {
            return 0;
        }

        return Math.max(height(root.getL()), height(root.getR())) + 1;
    }

    //------------------------------------------------------------------------------

    private static <T> boolean isBalancedImproved(Node<T> root) {
        return checkHeight(root) != -1;

    }

    private static <T> int checkHeight(Node<T> root) {
        if(root == null) return 0;

        int l = checkHeight(root.getL());
        if(l == -1) return -1;

        int r = checkHeight(root.getR());
        if(r == -1) return -1;

        if(Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Node<Integer> r = new Node<>(5);
        Node<Integer> r_l = new Node<>(3);
        Node<Integer> r_r = new Node<>(6);
        r.left(r_l).right(r_r);

        Node<Integer> r_l_l = new Node<>(2);
        Node<Integer> r_l_r = new Node<>(4);
        r_l.left(r_l_l).right(r_l_r);

//        System.out.println(isBalanced(r, 1));
        System.out.println(isBalancedImproved(r));

        Node<Integer> r_l_l_l = new Node<>(1);
        r_l_l.left(r_l_l_l);

//        System.out.println(isBalanced(r, 1));
        System.out.println(isBalancedImproved(r));
    }

}
