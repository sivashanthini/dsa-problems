/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
 */
package array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<>();
        if (numRows <= 0)
            return pascalList;
        for (int i = 0; i < numRows; i++) {
            List<Integer> pascalRow = new ArrayList<>();
            pascalList.add(pascalRow);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    pascalRow.add(1);
                else {
                    pascalRow.add(pascalList.get(i-1).get(j) + pascalList.get(i-1).get(j-1));
                }
            }
        }
        return pascalList;
    }
}
