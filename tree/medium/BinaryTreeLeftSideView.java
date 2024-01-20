/*
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
NOTE: The value comes first in the array which have lower level.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 109

Input Format
First and only argument is a root node of the binary tree, A.

Output Format
Return an integer array denoting the left view of the Binary tree.

Example Input

Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8

Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5

Example Output
Output 1:
 [1, 2, 4, 8]

Output 2:
 [1, 2, 4, 5]
 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
public class BinaryTreeLeftSideView {
    public ArrayList<Integer> leftSideViewIterative(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(A);
        TreeNode lastNode = A;
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node.right != null) deque.add(node.right);
            if (node.left != null) deque.add(node.left);
            if (lastNode == node) {
                list.add(node.val);
                if (!deque.isEmpty()) lastNode = deque.getLast();
            }
        }
        return list;
    }
    public ArrayList<Integer> leftSideViewRecursive(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list;
        helper(A, 0, list);
        return list;
    }
    private void helper(TreeNode node, int level, ArrayList<Integer> list) {
        if (node == null) return;
        if (list.size() == level) list.add(node.val);
        helper(node.left, level+1, list);
        helper(node.right, level+1, list);
    }
}
