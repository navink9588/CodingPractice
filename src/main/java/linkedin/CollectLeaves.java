package linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/5/18
 *
 * https://www.careercup.com/question?id=5121188207525888
 */
public class CollectLeaves {

    private List<List<TreeNode>> collectLeaves(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        collectLeaves(result, root);
        return result;
    }

    private int collectLeaves(List<List<TreeNode>> result, TreeNode node) {
        if (node == null)
            return -1;

        int left = collectLeaves(result, node.left);
        int right = collectLeaves(result, node.right);
        int height = Math.max(left, right) + 1;

        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(node);
        return height;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;

        CollectLeaves collectLeaves = new CollectLeaves();

        List<List<TreeNode>> result = collectLeaves.collectLeaves(n1);
        System.out.println(result);
    }
}
