/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
package string.easy;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             if (!map.containsKey(s.charAt(i)))
                 map.put(s.charAt(i), 1);
             else
                 map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
         }
         for (int i = 0; i < t.length(); i++) {
             if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0)
                 map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
             else
                 return false;
         }
         return true;
    }
}
