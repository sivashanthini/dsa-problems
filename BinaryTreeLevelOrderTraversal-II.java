/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]

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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<Integer> levelList = new ArrayList<>();
        ArrayList<Integer> levelElements = new ArrayList();
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null)
            return levelOrderList;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            levelList.add(count);
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.removeFirst();
                levelElements.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        int noOfLevels = levelList.size();
        int j = 0;
        int totalElements = 0;
        for (int i = noOfLevels; i > 0; i--) {
            int noOfElements = levelList.get(i-1);
            totalElements = totalElements + noOfElements;
            ArrayList<Integer> result = new ArrayList();
            j = levelElements.size() - totalElements;
            while (noOfElements > 0) {
                result.add(levelElements.get(j));
                j++;
                noOfElements--;
            }
            levelOrderList.add(result);
        }
        return levelOrderList;
    }
}
