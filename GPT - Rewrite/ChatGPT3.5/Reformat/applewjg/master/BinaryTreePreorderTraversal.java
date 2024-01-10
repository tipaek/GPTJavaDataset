import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversal {

    // Recursive solution 1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal1(root.left));
        result.addAll(preorderTraversal1(root.right));
        return result;
    }

    // Recursive solution 2
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversalRe(root, result);
        return result;
    }

    private void preorderTraversalRe(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalRe(root.left, result);
        preorderTraversalRe(root.right, result);
    }

    // Iterative solution 1 (using Stack)
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    // Iterative solution 2 (using Stack)
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                result.add(current.val);
                current = current.left;
            } else {
                current = stack.pop().right;
            }
        }
        return result;
    }

    // Morris traversal (Threaded tree)
    public List<Integer> preorderTraversal5(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode node = current.left;
                while (node.right != null && node.right != current) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = current;
                    result.add(current.val);
                    current = current.left;
                } else {
                    node.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        List<Integer> result = solution.preorderTraversal3(root);

        System.out.println("Preorder traversal result: " + result);
    }
}
