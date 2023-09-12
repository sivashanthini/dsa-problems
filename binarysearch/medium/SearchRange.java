/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
package binarysearch.medium;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, mid = 0, end = nums.length - 1;
        int[] result = new int[]{-1, -1};
        if (nums.length == 0)
            return result;
        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        while (low <= end) {
            mid = low + (end - low) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                break;
            } else if (nums[mid] < target)
                low = mid + 1;
            else
                end = mid - 1;
        }
        //check the elements on the right side eg : [1,2,2,3,3] target  = 3
        for (int i = result[0] + 1; i < nums.length; i++) {
            if (nums[i] == target)
                result[1] = i;
            else
                break;
        }
        //check the elements on the left side eg : [2,2,3,3] target  = 3
        for (int i = result[0] - 1; i >= 0; i--) {
            if (nums[i] == target) {
                if (result[1] == -1) //if [3,3,3] check in both sides
                    result[1] = result[0];
                result[0] = i;
            } else
                break;
        }
        if (result[0] != -1 && result[1] == -1) //if only one element as target [1,2 3,4] target = 3
            result[1] = result[0];
        return result;
    }
}
