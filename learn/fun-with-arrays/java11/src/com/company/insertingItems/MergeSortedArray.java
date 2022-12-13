package com.company.insertingItems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums1Copy = nums1.clone();
        int[] nums1Copy2 = nums1.clone();

        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        mySolution(nums1, m, nums2, n);
        assert Arrays.equals(nums1, new int[]{1, 2, 2, 3, 5, 6}) : "1 my solution failed";

        otherSolution(nums1Copy, m, nums2, n);
        assert Arrays.equals(nums1Copy, new int[]{1, 2, 2, 3, 5, 6}) : "1 other solution failed";

        otherSolutionReadable(nums1Copy2, m, nums2, n);
        assert Arrays.equals(nums1Copy2, new int[]{1, 2, 2, 3, 5, 6}) : "1 other solution failed";
    }

    private static void otherSolutionReadable(int[] nums1, int m, int[] nums2, int n) {
        for (
                int index = m + n - 1, nums1Index = m - 1, nums2Index = n - 1;
                nums2Index >= 0;
                index--
        ) {
            if (nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            } else {
                nums1[index] = nums2[nums2Index--];
            }
        }
    }

    /**
     * https://leetcode.com/problems/merge-sorted-array/solutions/2120234/visual-explanation-o-1-space-java/
     */
    private static void otherSolution(int[] A, int m, int[] B, int n) {
        for ( int i = m+n-1, a = m-1, b = n-1; b>=0; i-- ) {
            if (a >= 0 && A[a] > B[b]) A[i] = A[a--];
            else A[i] = B[b--];
        }
    }

    private static void mySolution(int[] arr1, int arr1Size, int[] arr2, int arr2Size) {
        System.arraycopy(arr2, 0, arr1, arr1Size, arr2Size);
        Arrays.sort(arr1);
    }

}
