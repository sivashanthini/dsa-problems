/*
You are given an Array A of size N.

Find for how many elements, there is a strictly smaller element and a strictly greater element.

Input Format

Given only argument A an Array of Integers.
Output Format

Return an Integer X, i.e number of elements.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e6
For Example

Example Input:
    A = [1, 2, 3]

Example Output:
    1

Explanation:
    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.
 */
package array.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class SmallerAndGreater {
    public int solve(ArrayList<Integer> A) {
        if (A.size() == 0 || A.size() == 1 || A.size() == 2)
            return 0;

        HashMap<Integer, Integer> map = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer num : A) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        int countOfMin = map.get(min);
        int countOfMax = map.get(max);

        if (A.size() == countOfMax || A.size() == countOfMin) //all same numbers
            return 0;
        return A.size() - countOfMax - countOfMin;
    }

    public int solve(int[] A) {
        int count = 0;
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > high)
                high = A[i];
            if (A[i] < low)
                low = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > low && A[i] < high)
                count++;
        }
        return count;
    }
}
