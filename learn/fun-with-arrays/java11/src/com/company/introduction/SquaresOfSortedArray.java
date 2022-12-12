package com.company.introduction;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/858549738/
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};

        assert Arrays.equals(mySolution(nums), new int[]{0,1,9,16,100}) : "1 my solution failed";
        assert Arrays.equals(otherSolution(nums), new int[]{0,1,9,16,100}) : "1 other solution failed";


        System.out.println("all good");
    }

    private static int[] otherSolution(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int index = nums.length- 1;
        int result[] = new int [nums.length];
        while(left<=right)
        {
            if(Math.abs(nums[left])>Math.abs(nums[right]))
            {
                result[index] = nums[left] * nums[left];
                left++;
            }
            else
            {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }

    private static int[] mySolution(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);

        return result;
    }


}
