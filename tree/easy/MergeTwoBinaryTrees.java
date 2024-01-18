/*
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:
Input: root1 = [1], root2 = [1,2]
Output: [2,2]

Constraints:
    The number of nodes in both trees is in the range [0, 2000].
    -104 <= Node.val <= 104
 */
package tree.easy;

import tree.TreeNode;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Stack<Node> stack = new Stack<>();
        Node temp = new Node(root1, root2);
        stack.add(temp);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.first == null || node.second == null) continue;
            node.first.val += node.second.val;
            if (node.first.left == null) node.first.left = node.second.left;
            else {
                Node n = new Node(node.first.left, node.second.left);
                stack.add(n);
            }
            if (node.first.right == null) node.first.right = node.second.right;
            else {
                Node n = new Node(node.first.right, node.second.right);
                stack.add(n);
            }
        }
        return root1;
    }
    public TreeNode mergeRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeRecursive(root1.left, root2.left);
        root1.right = mergeRecursive(root1.right, root2.right);
        return root1;
    }
    class Node
    {
        TreeNode first, second;
        Node (TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }
}
