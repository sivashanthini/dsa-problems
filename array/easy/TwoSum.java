/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

*/
// Create a Hashmap,and check if target - key is in the map then return the index of key and (target-key), else add target - key to the map

package array.easy;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length <= 1)
            return result;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (!map.containsKey(diff)) map.put(nums[i], i);
            else {
                result[0] = (int) map.get(diff);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
