package binarysearch.easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if (nums[start] == target)
            return start;
        if (nums[end] == target) 
            return end;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target)
                return mid;
            if (target > nums[mid])
                start = mid + 1;
            else if (target < nums[end])
                end = mid - 1;
        }
        return -1;
    }
}
