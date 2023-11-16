/*
Problem: 1502. Can Make Arithmetic Progression From Sequence

Description: A sequence of numbers is called an arithmetic progression if the difference between any two consecutive
elements is the same. Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic
progression. Otherwise, return false.

 */

import java.util.ArrayList;

public class ArithmeticProgressionV1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
//        ArrayList<Integer> array = new ArrayList<>();

        if(arr.length <= 2) return true;
        int difference = -1;

        for(int i=0; i<arr.length; i++) {
            if(i == 2) difference = arr[1] - arr[0];
            int smaller = arr[i];
            int pivot = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < smaller) {
                    pivot = j;
                    smaller = arr[j];
                }
            }

            int aux = arr[i];
            arr[i] = smaller;
            arr[pivot] = aux;

            if(i >= 2) {
                if(difference != (arr[i] - arr[i-1])) {
                    return false;
                }
            }
        }

        return difference == (arr[arr.length - 1] - arr[arr.length - 2]);
    }
}
