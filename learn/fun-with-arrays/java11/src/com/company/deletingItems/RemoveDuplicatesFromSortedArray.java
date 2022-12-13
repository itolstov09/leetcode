package com.company.deletingItems;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};

//        int result = mySolution(ints);
//        assert result == 2 : "1 my solution failed";


        int[] ints2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

//        int result2 = mySolution(ints2);
//        assert result2 == 5 : "2 my solution failed";

        int[] clone = ints2.clone();
        int res = otherSolution(clone);
        assert res == 5;

    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/2601915/official-solution/
     * @param nums
     * @return
     */
    private static int otherSolution(int[] nums) {
        int insertIndex = 1;
        for(int i = 1; i < nums.length; i++){
            // We skip to next index if we see a duplicate element
            if(nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    /**
     * нет решения
     * @param ints
     * @return
     */
    private static int mySolution(int[] ints) {
        int uniqueCount = 1;
        int uniqueIndex = ints.length - 1;
        int i = uniqueIndex;

        while (true) {
            int number = ints[i];
            if (number == ints[i - 1]) {
                uniqueIndex--;
            } else {
                i--;
                break;
            }
            i--;

        }
        return 0;

    }

    /**
     * нет решения
     * @param ints
     * @return
     */
    private static int mySolution_old(int[] ints) {
        int uniqueNumberCount = 1;
        // основная ошибка - я почему-то решил что дубликат стоит куда-то сохранить, хотя он вообще не нужен
        int duplicateDestination = ints.length - 1; // индекс куда складывать дубликат

//        int shiftStart = i;
//        int shiftEnd = i;

        // перекинуть дубликаты в конец массива, сохранив индекс последнего уникального значения
        int i = 1;
        while (i < duplicateDestination) {
//            взять i-ый элемент
            int number = ints[i];
            // Если элемент не похож на предыдущий - он уникален, т.к. массив отсортирован
//            если он похож на i-1
//                сделать перестановку
            int prevNumber = ints[i - 1];
            if (number == prevNumber || number < prevNumber) {
                ints[i] = ints[duplicateDestination];
                ints[duplicateDestination] = number;
                duplicateDestination--;
                continue;
            }
//
            uniqueNumberCount++;
            i++;
        }
//        uniqueNumberCount++; //МАГИЯ О_О по какому то условию нужно действительно сделать инкремент и выдаст правильный результат

        return uniqueNumberCount;
    }
}
