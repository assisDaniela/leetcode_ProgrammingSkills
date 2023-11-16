/*
Problem: 66. Plus One

Description: You are given a large integer represented as an integer array digits, where each digits[i] is the ith
digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The
large integer does not contain any leading 0's. Increment the large integer by one and return the resulting array of
digits.

Constraints:
- 1 <= digits.length <= 100
- 0 <= digits[i] <= 9
- digits does not contain any leading 0's.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.IntFunction;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int leastSignificant = digits[digits.length-1];
        if(leastSignificant < 9) {
            int[] plusOneDigits = digits.clone();
            plusOneDigits[digits.length-1] += 1;
            return plusOneDigits;
        } else {
            int mostSignificant = digits[0];
            LinkedList<Integer> plusOneDigits = new LinkedList<Integer>();
            boolean addOne = true;
            plusOneDigits.addFirst(0);
            for (int i = digits.length - 2; i >= 0; i--) {
                int digit = (addOne ? digits[i] + 1 : digits[i]);

                if (digit == 10) {
                    digit = 0;
                    addOne = true;
                } else {
                    addOne = false;
                }

                plusOneDigits.addFirst(digit);
            }

            if (addOne) plusOneDigits.addFirst(1);
            int[] arrayPlusOneDigits = new int[plusOneDigits.size()];
            int index = 0;
            for (int digit : plusOneDigits) {
                arrayPlusOneDigits[index] = digit;
                index++;
            }

            return arrayPlusOneDigits;
        }
    }
}
