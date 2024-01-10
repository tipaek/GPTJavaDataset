/**
 * Definition for binary tree.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedRecursive(root) > -1;
    }

    public int isBalancedRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = isBalancedRecursive(root.left);
        int rightDepth = isBalancedRecursive(root.right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        boolean isBalanced = solution.isBalanced(root);

        System.out.println("Is the binary tree balanced? " + isBalanced);
    }
}
