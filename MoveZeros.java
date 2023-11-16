import java.util.ArrayList;

/*
Problem: 283. Move Zeroes

Description: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the
non-zero elements. Note that you must do this in-place without making a copy of the array.

 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        for(int i=0; i<length; i++) { // find zero
            if(nums[i] == 0) {
                for(int j=i+1; j<length; j++) { // find next non zero
                    if(nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;

                        break;
                    }
                }
            }
        }
    }
}
