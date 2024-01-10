/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length)
            return null;
        return buildTreeRe(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode buildTreeRe(int[] preorder, int s1, int[] inorder, int s2, int size) {
        if (size <= 0)
            return null;
        TreeNode node = new TreeNode(preorder[s1]);
        if (size == 1)
            return node;

        int pos = s2;
        while (pos <= (s2 + size - 1)) {
            if (inorder[pos] == preorder[s1])
                break;
            ++pos;
        }

        int leftLen = pos - s2;
        node.left = buildTreeRe(preorder, s1 + 1, inorder, s2, leftLen);
        node.right = buildTreeRe(preorder, s1 + leftLen + 1, inorder, pos + 1, size - leftLen - 1);
        return node;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        ConstructBinaryTreeFromPreorderAndInorder solution = new ConstructBinaryTreeFromPreorderAndInorder();
        TreeNode result = solution.buildTree(preorder, inorder);

        // Note: You can add tree traversal logic to check the result
    }
}
