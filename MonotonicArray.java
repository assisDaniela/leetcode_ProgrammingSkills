/*
Problem: 896. Monotonic Array

Description: An array is monotonic if it is either monotone increasing or monotone decreasing. An array nums is
monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j,
nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 */
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 2) return true;

        // find out if array should increase or decrease
        // search for the first 2 consecutive non equals numbers
        boolean isIncreasing = true;
        int start = 2;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] != nums[i]) {
                isIncreasing = nums[i-1] < nums[i];
                start = i+1;
                break;
            }
        }

        for(int i=start; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) continue;
            boolean pairIsIncreasing = nums[i-1] < nums[i];

            // XOR: if different -> true
            boolean xor = (!isIncreasing & pairIsIncreasing) | (isIncreasing & !pairIsIncreasing);
            if(xor) return false;
        }

        return true;
    }
}
