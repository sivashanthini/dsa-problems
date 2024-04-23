/*
Given a tree having nodes with value 0 and 1. write a function to return the number of islands
    0
  / | \
0   1  1
|   |  |
1   0  1
    |
    1
No. of islands : 4
 */
package tree.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsInATree {
    int countIslands(TreeNode root) {
        return countIslands(root, 0);
    }
    int countIslands(TreeNode root, int prev) {
        if (root == null) return 0;
        int curr = root.val == 1 && prev == 0 ? 1 : 0;
        for (TreeNode child : root.children)
            curr += countIslands(child, root.val);
        return curr;
    }
    private static class TreeNode {
        int val;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
