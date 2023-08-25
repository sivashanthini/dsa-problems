/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0

Constraints:
0 <= left <= right <= 231 - 1

Solution
First, we could return n directly, instead of m&n as others pointed out. (we will see why this is the case as well)
Basically, it finds the longest common prefix (LCP) of the inputs followed by 0 bits to the right. Note that, you should think about the 32 bit representation of the inputs i.e. the shorter input is 0 padded from the left to make them the same length. First, you should know that n & (n-1) is a simple operation that removes the rightmost 1 in n. Therefore, the algorithm iteratively clear out the rightmost 1 bit in n until it is equal to or smaller than m. If they become equal, we stop and return n, which is their LCP (followed by 0s since we cleared the 1s to right). In the other case, n becomes less than m when we stop. I claim, n becomes the LCP of the original n and m in this case as well. Let's see an example for an intuition. E.g. say n = 111, m = 101. We have n > m, so we iterate and get n = 110 (and still m = 101). Now, n > m still holds, so we iterate again. Then, we get n = 100 (and m = 101) and we stop since our n > m predicate is False. This shows n=100 is indeed the LCP of 111 and 101 followed by 0s.

Finally, why do we want to find the LCP followed by 0s?

The LCP part: This is their common parts, and any number between m and n will have this common prefix. Thus, we keep the prefix bits as they are since ANDing them with themselves will not change their values.
The followed by 0s part: The index where the LCP ends is important since it denotes that any bits to the right from that position will change its value as we go from m to n in the input range. Why? Think about a binary counter, when you increment it, some of its bits change. What is important here is that the the number of steps required to switch a bit doubles when we go from right to left. E.g. think about a 4 bit counter:
000
001
010
011
100
101
110
111
When the leftmost change its value once, both bits toward right changed value at least one time. (e.g. when we increment from 011 to 100). In fact, when the leftmost bit changes once, the middle one might change up to three times (e.g. if m = 001 and n = 110) and the rightmost bit might change up to 7 times (e.g. if m = 000 and n = 111).
Therefore, the resulting bits to the right side of LCP will be 0 since applying AND to the bits in those positions yields 0 since some numbers will definitely have 0 at that positions (some will have 1 of course but 0 is critical for AND).
 */

package bitmanipulation.medium;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = (right & (right-1));
        }
        return right;
    }
}
