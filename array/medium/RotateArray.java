/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Approach
The approach of the given code is to rotate an array nums by k positions to the right.

1 ->Computing the effective rotation k by taking the modulus of k with the length of the nums array.

2 ->Reversing the entire nums array.

3 ->Reversing the first k elements of the reversed nums array, and then reversing the remaining elements from index k to the end

Complexity
Time complexity:
The time complexity of this approach is O(N), where N is the length of the nums array.

Space complexity:
O(1)
The space complexity of the method is O(1) because it does not use any extra space that grows with the input size. The method performs the rotation in-place, modifying the original nums array.

 */
package array.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
