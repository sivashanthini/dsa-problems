/*
Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0


Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105


Follow up: Can you solve it in O(n) time complexity?
 */
package array.medium;

public class ShortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = 0;
        if (nums.length <= 1)
            return 0;
        for (start = 0; start < nums.length-1; start++) {
            if (nums[start] > nums[start+1])
                break;
        }
        if (start == nums.length-1)
            return 0;
        for (end = nums.length-1; end > 0; end--) {
            if (nums[end] < nums[end-1])
                break;
        }
        int min = nums[start], max = nums[start];
        for (int i = start+1; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= end+1; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}
