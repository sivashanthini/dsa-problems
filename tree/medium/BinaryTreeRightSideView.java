/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideViewIterativeLevelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        TreeNode lastNode = root;
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node.left != null) deque.add(node.left);
            if (node.right != null) deque.add(node.right);
            if (lastNode == node) {
                list.add(node.val);
                if (!deque.isEmpty()) lastNode = deque.getLast();
            }
        }
        return list;
    }

    public List<Integer> rightSideViewRecursiveDFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }
    private void helper(TreeNode node, List<Integer> list, int level) {
        if (node == null) return;
        if (list.size() == level) list.add(node.val);
        helper(node.right, list, level+1);
        helper(node.left, list, level+1);
    }
}
