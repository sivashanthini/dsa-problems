/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'
*/

package graph.medium;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int  i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, m, n, grid);
                }    
            }
        }
        return ans;
    }
    private void dfs(int i, int j, int m, int n, char[][] grid) {
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {  
            return;
        }
        grid[i][j] = '0';
        dfs(i+1, j, m, n, grid);
        dfs(i-1, j, m, n, grid);
        dfs(i, j+1, m, n, grid);
        dfs(i, j-1, m, n, grid);
        // if considering the diagonal elements as well
        //        dfs(i-1, j-1, visited, m, n, grid);
        //        dfs(i+1, j+1, visited, m, n, grid);
        //        dfs(i-1, j+1, visited, m, n, grid);
        //        dfs(i+1, j-1, visited, m, n, grid);
    }
}
