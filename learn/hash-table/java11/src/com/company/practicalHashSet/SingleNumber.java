package com.company.practicalHashSet;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] ints1 = {2,2,1};
        int[] ints2 = {4,1,2,1,2};
        int[] ints3 = {1};
        int[] ints4 = {1, 1, 2, 3, 3};

        assert 1 == singleNumber(ints1);
        assert 4 == singleNumber(ints2);
        assert 1 == singleNumber(ints3);
        assert 2 == singleNumber(ints4);
    }

    private static int singleNumber(int[] ints) {

        Arrays.sort(ints);
        for (int i = 1; i < ints.length; i += 2) {
            if (ints[i] != ints[i - 1]) {
                return ints[i - 1];
            }
        }
        return ints[ints.length - 1];
    }
}
