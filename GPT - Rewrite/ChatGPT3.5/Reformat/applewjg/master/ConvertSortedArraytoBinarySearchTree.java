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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTRe(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBSTRe(int[] num, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBSTRe(num, left, mid - 1);
        node.right = sortedArrayToBSTRe(num, mid + 1, right);

        return node;
    }
}
