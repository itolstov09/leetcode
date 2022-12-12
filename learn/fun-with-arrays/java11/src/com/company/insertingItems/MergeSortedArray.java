package com.company.insertingItems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;


        assert Arrays.equals(mySolution(nums1, m, nums2, n), new int[]{1, 2, 2, 3, 5, 6}) : "1 my solution failed";
    }

    private static int[] mySolution(int[] arr1, int arr1Size, int[] arr2, int arr2Size) {
        int size = arr1Size + arr2Size;
        int arr1Index = 0;
        int arr2Index = 0;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            boolean isArr1InsertComplete = arr1Index >= arr1Size;
            if (isArr1InsertComplete) {
                result[i] = arr2[arr2Index];
                arr2Index++;
                continue;
            }

            boolean isArr2InsertComplete = arr2Index >= arr2Size;
            if (isArr2InsertComplete) {
                result[i] = arr1[arr1Index];
                arr1Index++;
                continue;
            }


            int number;
            if (arr1[arr1Index] < arr2[arr2Index]) {
                    number = arr1[arr1Index];
                    arr1Index++;
            } else {
                number = arr2[arr2Index];
                arr2Index++;
            }
            result[i] = number;
        }

        return result;
    }
}
