/*
Author:     King, wangjingui@outlook.com
Date:       Dec 20, 2014
Problem:    Validate Binary Search Tree
Difficulty: Medium
Source:     https://oj.leetcode.com/problems/validate-binary-search-tree/
Notes:
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Solution: Recursion.
         1. Add lower & upper bound. O(n)
         2. Inorder traversal with one additional parameter (value of predecessor). O(n)
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRe(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRe(TreeNode root, long left, long right) {
        if (root == null) return true;

        return left < root.val && root.val < right &&
                isValidBSTRe(root.left, left, root.val) &&
                isValidBSTRe(root.right, root.val, right);
    }
}
