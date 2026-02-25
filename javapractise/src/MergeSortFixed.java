import java.util.ArrayList;

public class MergeSortFixed {
    /*public static <T extends Comparable<? super T>> void mergeSort(ArrayList<T> arr) {
        if (arr == null || arr.size() <= 1) return;
        @SuppressWarnings("unchecked")
        ArrayList<T>[] temp = new ArrayList[2];
        temp[0] = new ArrayList<>();
        temp[1] = new ArrayList<>();
        mergeSortHelper(arr, 0, arr.size() - 1, temp);
    }

    private static <T extends Comparable<? super T>> void mergeSortHelper(ArrayList<T> arr, int left, int right, ArrayList<T>[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid, temp);
            mergeSortHelper(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, int left, int mid, int right, ArrayList<T>[] temp) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        for (int i = 0; i < n1; i++) {
            temp[0].add(arr.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            temp[1].add(arr.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (temp[0].get(i).compareTo(temp[1].get(j)) <= 0) {
                arr.set(k++, temp[0].get(i++));
            } else {
                arr.set(k++, temp[1].get(j++));
            }
        }
        while (i < n1) {
            arr.set(k++, temp[0].get(i++));
        }
        while (j < n2) {
            arr.set(k++, temp[1].get(j++));
        }
        temp[0].clear();
        temp[1].clear();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(64);  // Test single element
        System.out.println("Before: " + list);
        mergeSort(list);
        System.out.println("After: " + list);  // No error

        list.clear();
        list.add(5); list.add(2); list.add(8); list.add(1);
        System.out.println("Before: " + list);
        mergeSort(list);
        System.out.println("After: " + list);  // [1,2,5,8]

        ArrayList<Integer> rkTest = new ArrayList<Integer>();
        //5, 8, 3, 9, 4, 1, 7
        rkTest.add(5);
        rkTest.add(8);
        rkTest.add(3);
        rkTest.add(9);
        rkTest.add(4);
        rkTest.add(1);
        rkTest.add(7);
        System.out.println("Before: " + rkTest);
        mergeSort(rkTest);
        System.out.println("After: " + rkTest);

    }*/
}
