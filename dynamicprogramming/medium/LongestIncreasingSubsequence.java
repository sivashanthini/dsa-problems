/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
package dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // int[] dp = new int[nums.length];
        // int max = 1;
        // Arrays.fill(dp, 1);
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] < nums[j]) {
        //             dp[i] = Math.max(dp[i], 1 + dp[j]);
        //             max = Math.max(max, dp[i]);
        //         }
        //     }
        // }
        // return max;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (list.get(list.size() - 1) < nums[i])
                list.add(nums[i]);
            else {
                int low = 0;
                int high = list.size() - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (list.get(mid) < nums[i]) low = mid + 1;
                    else high = mid - 1;
                }
                list.set(low, nums[i]);
            }
        }
        return list.size();
    }
}
