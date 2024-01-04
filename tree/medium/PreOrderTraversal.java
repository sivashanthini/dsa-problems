/*
Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.

Problem Constraints

1 <= number of nodes <= 105

Input Format

First and only argument is root node of the binary tree, A.

Output Format

Return an integer array denoting the preorder traversal of the given binary tree.

Example Input

Input 1:

   1
    \
     2
    /
   3

Input 2:

   1
  / \
 6   2
    /
   3
Example Output

Output 1:

 [1, 2, 3]

Output 2:

 [1, 6, 2, 3]
*/

package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> preorderTraversalList = new ArrayList<>();
        if (root == null)
            return preorderTraversalList;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                preorderTraversalList.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            if (curr == null) {
                curr = stack.pop().right;
            }
        }
        return preorderTraversalList;
    }
    public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> preorderTraversalList = new ArrayList<>();
        if (root == null)
            return preorderTraversalList;
        preorderTraversalRecursiveHelper(root, preorderTraversalList);
        return  preorderTraversalList;
    }
    private void preorderTraversalRecursiveHelper(TreeNode node, ArrayList<Integer> preorderTraversalList) {
        if (node == null) return;
        preorderTraversalList.add(node.val);
        preorderTraversalRecursiveHelper(node.left, preorderTraversalList);
        preorderTraversalRecursiveHelper(node.right, preorderTraversalList);
    }
}
