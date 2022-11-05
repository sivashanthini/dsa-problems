//Given an m x n matrix, return all elements of the matrix in spiral order.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiralList = new ArrayList<>();
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int left = 0, right = 0, round = 0, total = ((m + 1) * (n + 1));
        while (spiralList.size() < total) {
            while (right <= n && spiralList.size() != total) {
                spiralList.add(matrix[left][right]);
                right++;
            }
            right--;
            left++;
            
            while (left <= m && spiralList.size() != total) {
                spiralList.add(matrix[left][right]);
                left++;
            }
            m = m - 1;
            n = n - 1;
            right = n;
            left--;
           
            while (right >= round && spiralList.size() != total) {
                spiralList.add(matrix[left][right]);
                right--;
            }
            left = m;
            right++;
            round++;
           
            while (left >= round && spiralList.size() != total) {
                spiralList.add(matrix[left][right]);
                left--;
            }
            left++;
            right++;
           
        }
        return spiralList;
    }
}
