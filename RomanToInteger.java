/*
Problem: 13. Roman to Integer

Description: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply
X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

- I can be placed before V (5) and X (10) to make 4 and 9. (IV or IX)
- X can be placed before L (50) and C (100) to make 40 and 90. (XL or XC)
- C can be placed before D (500) and M (1000) to make 400 and 900. (CD or CM)

Given a roman numeral, convert it to an integer.

 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanInt = new HashMap<>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);
        romanInt.put('O', -1);

        if(s.length() == 1) return romanInt.get(s.charAt(0));
        int sum = 0;

        for(int i=0; i<s.length(); i++) {
            char next = (i+1 < s.length() ? s.charAt(i+1) : 'O');
            char curr = s.charAt(i);
            if(romanInt.get(curr) < romanInt.get(next)) {
                sum += (romanInt.get(next)-romanInt.get(curr));
                i++;
            } else {
                sum += romanInt.get(curr);
            }
        }

        return sum;
    }
}
