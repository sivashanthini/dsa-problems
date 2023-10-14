/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].


Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1


Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
 */
package sorting.hard;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }
    private static int mergeSort(int left, int right, int[] nums) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left)/2;
            count += mergeSort(left, mid, nums);
            count += mergeSort(mid+1, right, nums);
            count += merge(left, mid, right, nums);
        }
        return count;
    }
    private static int merge(int left, int mid, int right, int[] nums) {
        int count = 0, n1 = mid - left + 1, n2 = right - mid, j = 0;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = nums[left+i];
        for (int i = 0; i < n2; i++) R[i] = nums[mid+1+i];
        j = mid+1;
        for(int i = left; i <= mid; i++){
            while(j <= right && nums[i] > (2*(long)nums[j])){
                j++;
            }
            count += j-(mid+1);
        }
        j = 0;
        int i = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }
        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];
        return count;
    }
}
