/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a
binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:
    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.

Solution
Recursive :
Intution: Firstly observe both the arrays and think how they are formed from a tree,
          which index contain which part from the tree.

    Inorder Traversal: After storing the inorder traversal of tree we can see that root will always come in between
    and left of root will be all the nodes of left subtree and in right will be nodes of right subtree.

    Postorder Traversal: Here we can see that in the array firstly there will be all the left subtree nodes
    then all the right subtree nodes and then at last will be root
    So now we can say that we have the root node confirmed that is at last index of postorder traversal array

    Now we have to just recursively update the left and right subtree of the root using your two arrays.

Iterative :
    Starting from the last element of the postorder and inorder array,
    we put elements from postorder array to a stack and each one is the right child of the last one
    until an element in postorder array is equal to the element on the inorder array.
    Then, we pop as many as elements we can from the stack and decrease the mark in inorder array until
    the peek() element is not equal to the mark value or the stack is empty.
    Then, the new element that we are gonna scan from postorder array is the left child of the last element
    we have popped out from the stack.
Time complexity:
    The time complexity of this algorithm is O(n), where n is the number of nodes in the tree.
    We visit each node only once.

Space complexity:
    The space complexity of this algorithm is O(n).
    We create a hashmap to store the indices of the inorder traversal, which takes O(n) space.
    Additionally, the recursive call stack can go up to O(n) in the worst case if the binary tree is skewed.

 */
package tree.medium;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTreeIterative(int[] inorder, int[] B) {
        if (inorder.length != B.length || inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        int inorderLength = inorder.length - 1;
        int postOrderLength = B.length - 1;
        TreeNode prev = null;
        TreeNode root = new TreeNode(B[postOrderLength]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        postOrderLength--;

        while(postOrderLength >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[inorderLength]) {
                prev = stack.pop();
                inorderLength--;
            }
            TreeNode node = new TreeNode(B[postOrderLength]);
            if (prev != null) prev.left = node;
            else stack.peek().right = node;
            stack.push(node);
            postOrderLength--;
            prev = null;
        }
        return root;
    }
    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
         return buildTreeHelper(inorder, postorder, 0, inorder.length-1, postorder.length-1, map);
    }
     private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end, int pos, HashMap<Integer,Integer> map) {
         if (start > end || pos < 0) return null;
         if (start == end) return new TreeNode(inorder[start]);

         TreeNode root = new TreeNode(postorder[pos]);
         int index = map.get(postorder[pos]);
         root.left = buildTreeHelper(inorder, postorder, 0, index-1, pos-(end-index)-1, map);
         root.right = buildTreeHelper(inorder, postorder, index+1, end, pos-1, map);
         return root;
     }
}
