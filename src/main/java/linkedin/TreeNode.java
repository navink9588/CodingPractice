package linkedin;

/**
 * @author Navin Kumar
 * @date 7/5/18
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    @Override public String toString() {
        return String.valueOf(val);
    }
}
