/*
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.

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
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    private ArrayList<Integer> traversedList;

    public Solution () {
        traversedList = new ArrayList<>();
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null)
            return traversedList;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = A;
        
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
    //    inorderTraversal(A.left);
    //    traversedList.add(A.val);
    //    inorderTraversal(A.right);
        return traversedList;
    }
}
