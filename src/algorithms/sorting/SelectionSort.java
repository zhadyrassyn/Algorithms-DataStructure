package algorithms.sorting;

import util.StdOut;

import static algorithms.sorting.SortingUtils.exch;
import static algorithms.sorting.SortingUtils.less;

public class SelectionSort {
    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i+1; j < N; j++) {
                if(less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(min, i, arr);
        }
    }



    private static boolean isSorted(Comparable[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(less(arr[i], arr[i-1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 2, 1, 34, -1, 0, 3, -15};

        SelectionSort.sort(arr);

        for(int p: arr) {
            StdOut.print(p + " ");
        }

        StdOut.flush();
    }
}
