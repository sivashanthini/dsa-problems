/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
package string.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        // StringBuilder sb = new StringBuilder();
//        Stack<Character> stack =new Stack<>();
        // for (int i = 0; i < charArray.length; i++) {
        //     if (sb.length() > 0 && sb.charAt(sb.length()-1) == (charArray[i])) {
        //     //    stack.pop();
        //         sb.deleteCharAt(sb.length()-1);
        //     } else {
        //     //    stack.push(charArray[i]);
        //         sb.append(charArray[i]);
        //     }
        // }
        // return sb.toString();
        char[] charArray = s.toCharArray();

        int index = -1;
        for (char c : charArray) {
            if (index >= 0 && charArray[index] == c)
                index--;
            else
                charArray[++index] = c;
        }
        return new String(charArray, 0, index + 1);
    }
}
