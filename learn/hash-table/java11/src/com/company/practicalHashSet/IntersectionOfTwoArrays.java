package com.company.practicalHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] ints1_1 = {1,2,2,1};
        int[] ints1_2 = {2,2};
        int[] ints2_1 = {4,9,5};
        int[] ints2_2 = {9,4,9,8,4};

        assert Arrays.equals(new int[]{2}, intersection(ints1_1, ints1_2));
        int[] intersection1 = intersection(ints2_1, ints2_2);
        assert Arrays.equals(new int[]{9,4}, intersection1) || Arrays.equals(new int[]{4,9}, intersection1);
    }

    private static int[] intersection(int[] ints1, int[] ints2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer number : ints1) {
            set1.add(number);
        }
        for (Integer number : ints2) {
            set2.add(number);
        }

        Set<Integer> small;
        Set<Integer> big;

        if (set1.size() < set2.size()) {
            small = set1;
            big = set2;
        } else {
            small = set2;
            big = set1;
        }

        int[] arr = new int[small.size()];
        int index = 0;

        for (Integer number : small) {
            if (big.contains(number)) {
                arr[index] = number;
                index++;
            }
        }

        return Arrays.copyOf(arr, index);
    }
}
