/*
Using Count Array:

Maintain a count array countArr[] which keeps count of all elements greater than or equal to arr[i].

1) Declare an integer array countArr[] of size n + 1 (where n is the size of given array arr), and initialize it as zero.
2) Iterate through array arr, if arr[i] < 0, we ignore it, if arr[i] >= n, we increment countArr[n], else simply increment countArr[arr[i]].
3) Declare an integer totalGreater, which keeps count of elements greater than current element, and initialize it as countArr[arr[n]].
4) Iterate through count array countArr from last to first index, if at any point we find that totalGreater = i for countArr[i] > 0, we have found our solution. Else keep increasing totalGreater with countArr[i].

 */
package array.medium;

import java.util.Arrays;

public class NobleInteger {
    public int nobleIntegerUsingSorting(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if (arr[n-1] == 0) return 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i+1]) continue; //duplicate
            if (arr[i] == n-i-1) return arr[i];
        }
        return -1;
    }
    public int nobleIntegerWithoutSorting(int[] arr) {
        int n = arr.length;
        int[] countArray = new int[n+1];
        Arrays.fill(countArray, 0);
        for (int i = 0; i < n; i++) {
                // If current element is less than zero, it cannot be a solution so we skip it.
            if (arr[i] < 0) continue;
                // If current element is >= size of input array, if will be greater than all elements which can be
                // considered as our solution, as it cannot be greater than size of array.
            else if (arr[i] >= n) countArray[n]++;
                // Else we increase the count of elements >= our current array in countArr
            else countArray[arr[i]]++;
        }
        // Initially, countArr[n] is count of elements greater than all possible solutions
        int greater = countArray[n];
        for (int i = n-1; i >=0; i--) {
                // If totalGreater = current index, means we found arr[i] for which count of elements >= arr[i] is
                // equal to arr[i]
            if (greater == i && countArray[i] > 0) return i;
                // If at any point count of elements greater than arr[i] becomes more than current index, then it
                // means we can no longer have a solution
            else if (greater > i) return -1;
            // Adding count of elements >= arr[i] to totalGreater.
            greater += countArray[i];
        }
        return -1;
    }
}
