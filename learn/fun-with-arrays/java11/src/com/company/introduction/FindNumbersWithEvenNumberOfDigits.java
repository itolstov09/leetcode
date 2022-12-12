package com.company.introduction;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/858537733/
 */
public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 345, 2, 6, 7896};

        assert mySolution(nums) == 2 : "1 my solution failed";
        assert otherSolution(nums) == 2 : "1 other solution failed";

    }

    private static int otherSolution(int[] nums) {
        int result = 0;

        for(int i = 0 ; i < nums.length ; i++){

            int count = (int)Math.log10(nums[i]) + 1; //example (234 log 10 + 1) = ( 2 + 1 ) = 3 - number of digit

            if(count % 2 == 0) result++;
        }

        return result;
    }

    private static int mySolution(int[] nums) {
        int evenDigitsNumberCount = 0;
        for (int number : nums) {
            String numberAsString = String.valueOf(number);
            if (numberAsString.length() % 2 == 0) {
                evenDigitsNumberCount++;
            }
        }

        return evenDigitsNumberCount;
    }


}
