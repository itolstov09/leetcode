package com.company.introduction;

/**
 * https://leetcode.com/problems/max-consecutive-ones/submissions/858490042/
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 0, 1};
        int[] numsWithOneElement = new int[]{1};
        int[] numsEmpty = new int[]{};

        assert mySolution(nums) == 2 : "1 my solution failed";
        assert otherSolution(nums) == 2: "1 other solution failed";

        assert mySolution(numsWithOneElement) == 1 : "2 my solution failed";
        assert otherSolution(numsWithOneElement) == 1: "2 other solution failed";

        assert mySolution(numsEmpty) == 0 : "3 my solution failed";
        assert otherSolution(numsEmpty) == 0: "3 other solution failed";

        System.out.println("all good");
    }


    private static int mySolution(int[] nums) {
        int oneCount = 0;
        int maxOneCount = 0;

        for (int number : nums) {
            oneCount = number == 1 ? oneCount + 1 : 0;
            maxOneCount = Math.max(maxOneCount, oneCount);
        }

        return maxOneCount;
    }

    private static int otherSolution(int[] nums) {
        int count = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] ==1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        return Math.max(count, max);
    }
}
