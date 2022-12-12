package com.company.insertingItems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/duplicate-zeros/submissions/858573415/
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        int[] copy = Arrays.copyOf(nums, nums.length);

        int[] result = {1, 0, 0, 2, 3, 0, 0, 4};

        mySolution(nums);
        assert Arrays.equals(nums, result) : "1 my solution failed";

        otherSolution(copy);
        assert Arrays.equals(copy, result) : "1 other solution failed";

        System.out.println("all good");
    }


    /**
     * O(n^2) - slow speed
     *
     * @param nums
     */
    private static void mySolution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }

            if (nums.length - 1 - i >= 0) {
                System.arraycopy(
                        nums,
                        i,
                        nums,
                        i + 1,
                        nums.length - 1 - i
                );
            }
            i++;
        }
    }

    /**
     * O(n)
     *
     * @param arr
     */
    private static void otherSolution(int[] arr) {
        int zerosCount = 0;
        int length = arr.length;
        for (int number : arr) {
            if (number == 0) {
                zerosCount++;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            int curIndex = i + zerosCount;
            if (curIndex < length) {
                arr[curIndex] = arr[i];
            }
            if (arr[i] == 0) {
                if (curIndex - 1 < length) {
                    arr[curIndex - 1] = 0;
                }
                zerosCount--;
            }
        }
    }
}
