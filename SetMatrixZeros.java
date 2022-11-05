
//As additional space is needed the time complexity is : O(MN) and space is O(M+N)
class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    indexList.add(i);
                    indexList.add(j);
                }
            }
        }
  
        for (int itr = 0; itr < indexList.size(); itr++) {
            int  row = indexList.get(itr);
            int  col = indexList.get(++itr);
           
            for (int i = 0; i < matrix[0].length; i++) 
                matrix[row][i] = 0;
            for (int i = 0; i < matrix.length; i++) 
                matrix[i][col] = 0;
        }
    }
}

//To reduce space complexity to O(1) we can make the first row itself as an indicator of whether that row or col needs be made zero or not.

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false, isRow = false; //flag to check any num in first row or col is zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                     if (i == 0)
                        isRow = true;
                    if (j == 0)
                        isCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (isRow) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if (isCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
  
    }
}
