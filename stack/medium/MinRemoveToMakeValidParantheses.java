/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.


Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */
package stack.medium;

public class MinRemoveToMakeValidParantheses {
    public String minRemoveToMakeValid(String s) {
        // if (s == null || s.isEmpty())
        //     return s;
        // Stack<Pair> stack = new Stack();
        // for (int i = 0; i < s.length(); i++) {
        //     if (!stack.isEmpty() && stack.peek().getFirst().equals('(') && s.charAt(i) == ')')
        //         stack.pop();
        //     else if (s.charAt(i) == '(' || s.charAt(i) == ')')
        //         stack.push(new Pair(s.charAt(i), i));
        // }
        // if (stack.isEmpty())
        //     return s;
        // StringBuilder strBu = new StringBuilder();
        // for (int i = s.length() - 1; i >= 0; i--) {
        //     if (!stack.isEmpty() && stack.peek().getSecond() == i) {
        //         stack.pop();
        //         continue;
        //     }
        //     strBu.append(s.charAt(i));
        // }
        // return strBu.reverse().toString();
        char[] charArray = s.toCharArray();
        int open = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(')
                open++;
            else if (charArray[i] == ')') {
                if (open == 0)
                    charArray[i] = '*';
                else open--;
            }
        }
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '(' && open > 0) {
                charArray[i] = '*';
                open--;
            }
        }
        int i = 0;
        for (char c : charArray) {
            if (c != '*')
                charArray[i++] = c;
        }
        return new String(charArray, 0 , i);
    }
}

// class Pair {
//     private Character first;
//     private Integer second;
//     public Pair(Character first, Integer second) {
//         this.first = first;
//         this.second = second;
//     }
//     public Character getFirst() { return first; }
//     public Integer getSecond() { return second; }
// }
