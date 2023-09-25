/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
package string.easy;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        if (strArray.length != pattern.length()) return false;

        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            map1.putIfAbsent(strArray[i], pattern.charAt(i));
            map2.putIfAbsent(pattern.charAt(i), strArray[i]);
            Character charPattern = map1.get(strArray[i]);
            String string = map2.get(pattern.charAt(i));
            if (charPattern != pattern.charAt(i) || !strArray[i].equals(string))
                return false;
        }
        return true;
    }
}
