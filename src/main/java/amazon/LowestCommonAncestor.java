package amazon;

/**
 * @author Navin Kumar
 * @date 7/23/18
 */
public class LowestCommonAncestor {

    private static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private Node lca(Node root, int n1, int n2) {
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node l = lca(root.left, n1, n2);
        Node r = lca(root.right, n1, n2);

        if(l != null && r != null)
            return root;

        return l != null ? l : r;
    }

    // If any or both n1 and n2 are missing in the tree
    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4,5): " + lca.lca(root, 4, 5).data);
        System.out.println("LCA(4,6): " + lca.lca(root, 4, 6).data);
        System.out.println("LCA(3,4): " + lca.lca(root, 3, 4).data);
        System.out.println("LCA(2,4): " + lca.lca(root, 2, 4).data);
    }

}
