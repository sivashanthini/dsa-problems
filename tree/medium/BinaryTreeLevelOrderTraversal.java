/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
*/

package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        List<List<Integer>> levelOrderList = new ArrayList();
        if (root == null)
            return levelOrderList;
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelElements = new ArrayList();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.removeFirst();
                levelElements.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            levelOrderList.add(levelElements); 
        }
        return levelOrderList;
        
    }
}
