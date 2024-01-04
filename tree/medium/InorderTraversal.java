/*
Given a binary tree, return the inorder traversal of its nodes' values.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

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
 [1, 3, 2]

Output 2:
 [6, 1, 3, 2]
*/

package tree.medium;


import tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> traversedList = new ArrayList<>();
        if (root == null)
            return traversedList;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (curr == null) {
                curr = stack.pop();
                traversedList.add(curr.val);
                curr = curr.right;
            }
        }
        return traversedList;
    }

    public ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }
    private void inorderTraversalHelper(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return;
        inorderTraversalHelper(node.left, list);
        list.add(node.val);
        inorderTraversalHelper(node.right, list);
    }
}
