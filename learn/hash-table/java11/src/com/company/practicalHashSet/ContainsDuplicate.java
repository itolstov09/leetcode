package com.company.practicalHashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/submissions/872544607/
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3, 1};
        int[] ints2 = {1,2,3,4};
        int[] ints3 = {1,1,1,3,3,4,3,2,4,2};

        assert containsDuplicate(ints1);
        assert !containsDuplicate(ints2);
        assert containsDuplicate(ints3);
    }

    private static boolean containsDuplicate(int[] ints) {
        Set<Integer> items =new HashSet<>();
        for (int number : ints) {
            if (items.contains(number)) {
                return true;
            }
            items.add(number);
        }

        return false;
    }
}
