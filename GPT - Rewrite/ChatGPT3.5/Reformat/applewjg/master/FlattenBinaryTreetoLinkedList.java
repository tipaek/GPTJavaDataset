/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        flattenRecursive(root);
    }

    private TreeNode flattenRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = flattenRecursive(root.left);
        TreeNode rightTail = flattenRecursive(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return (rightTail != null) ? rightTail : (leftTail != null) ? leftTail : root;
    }
}
