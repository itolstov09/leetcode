package com.company.deletingItems;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 *
 * Задача решена, но почему-то код проверяющий массив ints говорит что не правильно:
 * https://leetcode.com/problems/remove-element/submissions/859063341/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] ints = {3, 2, 2, 3};
        int[] ints2 = {0,1,2,2,3,0,4,2};


//        int result = mySolution(ints, 3);
//        assert result == 2;

        int result2 = mySolution(ints2, 2);
        assert result2 == 3;

    }

    private static int mySolution(int[] ints, int target) {
        int targetCount = 0;
        int p1 = 0;
        int[] pair = findLastNonTargetIndexWithTargetCount(ints, target, targetCount);
        int p2 = pair[0];
        targetCount = pair[1];

        while (p1 <= p2) {
            int number = ints[p1];
            if (number == target) {
                targetCount++;

                int temp = ints[p2];
                ints[p1] = temp;
                ints[p2] = number;
                pair = findLastNonTargetIndexWithTargetCount(ints, target, targetCount);
                p2 = pair[0];
                targetCount = pair[1];
            }
            p1++;
        }

        return targetCount;
    }

    private static int[] findLastNonTargetIndexWithTargetCount(int[] ints, int target, int targetCount) {
        int i = ints.length - 1 - targetCount;
        int nonTargetIndex = i;
        while (i >= 0) {
            if (ints[i] != target) {
                nonTargetIndex = i;
                break;
            }
            targetCount++;
            i--;
        }
        return new int[]{nonTargetIndex, targetCount};
    }
}
