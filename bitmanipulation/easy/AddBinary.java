/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
package bitmanipulation.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        char[] result = new char[(a.length() + b.length() + 1)];
        int i = aArray.length-1;
        int j = bArray.length-1;
        char rem = '0';
        int k = result.length - 1;
        while (i >= 0 && j >= 0) {
            char aNum = aArray[i--];
            char bNum = bArray[j--];
            if ((aNum == '1' && bNum == '0' && rem == '0') || (aNum == '0' && bNum == '1' && rem == '0') || (aNum == '0' && bNum == '0' && rem == '1')) {
                result[k--] = '1';
                rem = '0';
            }
            else if (aNum == '0' && bNum == '0' && rem == '0') {
                result[k--] = '0';
                rem = '0';
            }
            else if ((aNum == '0' && bNum == '1' && rem == '1') || (aNum == '1' && bNum == '0' && rem == '1') || (aNum == '1' && bNum == '1' && rem == '0')){
                result[k--] = '0';
                rem = '1';
            } else if (aNum == '1' && bNum == '1' && rem == '1') {
                result[k--] = '1';
                rem = '1';
            }
        }
        if (i >= 0) {
            for (; i >= 0; i--) {
                char aNum = aArray[i];
                if ((rem == '1' && aNum == '0') || (rem == '0' && aNum == '1')) {
                    rem = '0';
                    result[k--] = '1';
                } else if ((rem == '1' && aNum == '1')) {
                    rem = '1';
                    result[k--] = '0';
                } else if ((rem == '0' && aNum == '0')) {
                    rem = '0';
                    result[k--] = '0';
                }
            }
        } else if (j >= 0) {
            for (; j >= 0; j--) {
                char bNum = bArray[j];
                if ((rem == '1' && bNum == '0') || (rem == '0' && bNum == '1')) {
                    rem = '0';
                    result[k--] = '1';
                } else if ((rem == '1' && bNum == '1')) {
                    rem = '1';
                    result[k--] = '0';
                } else if ((rem == '0' && bNum == '0')) {
                    rem = '0';
                    result[k--] = '0';
                }
            }
        }
        if (rem == '1')
            result[k] = '1';
        StringBuilder str = new StringBuilder();
        for (k = 0; k < result.length; k++) {
            if (result[k] == '\u0000')
                continue;
            str.append(result[k]);
        }
        return str.toString();

    }
}
