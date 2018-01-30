package algorithms.sorting;

public class SortingUtils {

    public static void exch(int i, int j, Comparable[] arr) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
