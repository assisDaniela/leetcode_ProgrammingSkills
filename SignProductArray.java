/*
Problem: 1822. Sign of the Product of an Array

Description: There is a function signFunc(x) that returns:

- 1 if x is positive.
- -1 if x is negative.
- 0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).

 */

public class SignProductArray {
    public int arraySign(int[] nums) {
        if(nums[0] == 0) return 0;
        // if number is positive -> sign is false
        // if number is negative -> sign is true
        boolean productSign = nums[0] < 0;

        for(int i=1; i<nums.length; i++) {
            int num = nums[i];

            if(num == 0) return 0;
            boolean numSign = num < 0;
            productSign = (!productSign & numSign) | (!numSign & productSign);
        }

        if(productSign) return -1;
        else return 1;
    }
}
