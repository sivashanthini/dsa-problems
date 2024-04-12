/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:
    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1


Solution

Approach
As we know that, we have to check 1 to n ( where n would be arr length ).
So each index ( 0 to n-1 ) would be the representative if we have visited or not.
But here are few edge cases

    What if element is already negative ?
    We will make this zero, because negative cannot be part of the answer, so we don't need that.
    What if index contains zero, so when we try to mark it negative there would be no impact ?
    So to avoid this we will replace one negative value ( Integer.MIN_VALUE ) so that we know this is visited. ( It could be any negative value )

At the end, once we marked all index we will revisit the array, first index which is containing non-negative value would be our answer here.
Complexity

    Time complexity: O(n)

    Space complexity: O(1)

 */
package array.hard;

import java.util.HashSet;

public class SmallestPositiveNumber {
    public int solutionWithExtraSpace(int[] A) {
        // Implement your solution here
        if (A.length == 0) return 0;
        int smallest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (!set.contains(i)) return i;
        }
        if (set.size() == 0) return smallest;
        return smallest;
    }
    public int solutionWithoutExtraSpace(int[] A) {
        if (A.length == 0) return 0;
        int n = A.length;
        // mark all negatives to zero, because they are not useful
        for (int i = 0; i < n; i++) {
            if (A[i] < 0)
                A[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int index = Math.abs(A[i]) - 1;
            // out of bound index
            if (index < 0 || index >= n) continue;
            if (A[index] > 0) {
                // mark as visited
                A[index] *= -1;
            } else if (A[index] == 0) {
                // if this index contains zero mark this visited by placing any negative value
                A[index] = Integer.MIN_VALUE + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // first non-negative index would be our answer
            if (A[i] >= 0) return i+1;
        }
        return n + 1;
    }
}
