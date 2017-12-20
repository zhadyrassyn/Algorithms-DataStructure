package algorithms;

import util.StdOut;

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

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(int i, int j, Comparable[] arr) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
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
