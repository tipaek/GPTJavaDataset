/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
            return null;
        return buildTreeRe(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeRe(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (e2 < s2)
            return null;
        if (s2 == e2)
            return new TreeNode(postorder[e2]);

        int j = -1;
        for (int i = s1; i <= e1; i++) {
            if (inorder[i] == postorder[e2]) {
                j = i;
                break;
            }
        }

        int leftLen = j - s1;
        TreeNode root = new TreeNode(postorder[e2]);
        root.left = buildTreeRe(inorder, s1, j - 1, postorder, s2, s2 + leftLen - 1);
        root.right = buildTreeRe(inorder, j + 1, e1, postorder, s2 + leftLen, e2 - 1);

        return root;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        ConstructBinaryTreeFromInorderAndPostorder solution = new ConstructBinaryTreeFromInorderAndPostorder();
        TreeNode result = solution.buildTree(inorder, postorder);

        // Note: You can add tree traversal logic to check the result
    }
}
