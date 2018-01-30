package algorithms.sorting;

import static algorithms.sorting.SortingUtils.exch;
import static algorithms.sorting.SortingUtils.less;

public class InsertionSort {

    public static void sort(Comparable[] arr) {
        for(int i = 2; i < arr.length; i++) {
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                exch(j, j-1, arr);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 2, 1, 34, -1, 0, 3, -15};

        InsertionSort.sort(arr);

        for(int k: arr) {
            System.out.print(k + ", ");
        }
    }
}
