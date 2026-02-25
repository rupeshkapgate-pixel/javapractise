import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class BruteForceSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //5, 8, 3, 9, 4, 1, 7
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(0);
        arr.add(0);
        arr.add(0);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(3);
        arr2.add(5);
        //arr.add(7);
        //4, 9, 5, 2, 9, 5, 7, 10
       // out.println(arr2);
        //out.println(arr);
       // ArrayList<String> result = dutchNationalFlag();
        //out.println(result);

        int[] myArray = {1, 2, 6, 3, 5 , 4, 8};
       // List<Integer> insertSort1 = Arrays.stream(myArray).boxed().collect(Collectors.toList());

        //insertionSort2(myArray.length, insertSort1);
        out.println(dutchNationalFlag());
    }
    public static ArrayList<Integer> selection_sort(ArrayList<Integer> integerArrayList) {

        for(int i = 0; i< integerArrayList.size()-1; i++){
            int minIndex = i;
            for(int j = i+1; j < integerArrayList.size(); j++ ){
                if(integerArrayList.get(j) < integerArrayList.get(minIndex)){
                    minIndex = j;
                }
            }
            Collections.swap(integerArrayList, minIndex, i);

            int temp = integerArrayList.get(i);
            integerArrayList.set(i, integerArrayList.get(minIndex));
            integerArrayList.set(minIndex, temp);
        }
        // Write your code here.
        return integerArrayList;
    }

    public static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr) {
        for(int i = 0; i < arr.size()-1; i++){
            for(int j = arr.size()-1; j > i ; j--){
                if(arr.get(j) < arr.get(j-1)){
                    Collections.swap(arr, j, j-1);
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arr) {
        for(int i = 0; i < arr.size(); i++){
            int temp = arr.get(i);
            int sortIndex = i-1;
            while(sortIndex >= 0 && arr.get(sortIndex)> temp){
                arr.set(sortIndex+1, arr.get(sortIndex));
                sortIndex--;
            }
            arr.set(sortIndex+1, temp);
        }
        return arr;
    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        mergeSortHelper(arr,0,arr.size()-1);
        return arr;
    }
    public static void merge(ArrayList<Integer> arr, int left, int mid, int right){
        ArrayList<Integer>[] aux = new ArrayList[2];
        aux[0] = new ArrayList<>();
        aux[1] = new ArrayList<>();
        int n1 = mid - left + 1, n2 = right - mid;

        // Creating left Sub Array
        for (int i = 0; i < n1; i++) {
            aux[0].add(arr.get(left + i));
        }

        // Creating right Sub array
        for (int j = 0; j < n2; j++) {
            aux[1].add(arr.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;

        // combine left and right into auxiliary array
        while (i < n1 && j < n2) {
            if (aux[0].get(i).compareTo(aux[1].get(j)) <= 0) {
                arr.set(k++, aux[0].get(i++));
            } else {
                arr.set(k++, aux[1].get(j++));
            }
        }
        // adding remaining elements from auxiliary arrays
        while (i < n1) {
            arr.set(k++, aux[0].get(i++));
        }
        while (j < n2) {
            arr.set(k++, aux[1].get(j++));
        }
    }

    public static void mergeSortHelper(ArrayList<Integer> arr, int left, int right){
        if(left == right){
            return;
        }
        //int mid = left + (right - left) / 2;
        int mid = left +  (right - left)/2;
        // Split the work
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid+1, right);
        merge(arr, left , mid, right);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr){
        quickSortHelper(arr, 0, arr.size());
        return arr;
    }
    public static void  quickSortHelper(ArrayList<Integer> arr, int left, int right){
        if (left == right){
            return;
        }
        int randomIndex = (int)(Math.random() * (left - right + 1)) + left;
        Collections.swap(arr, left, randomIndex);
        int piotIndex = lomutoPartioning(arr, left, right);
        quickSortHelper(arr, left, piotIndex - 1);
        quickSortHelper(arr, piotIndex, right);

    }
    public static int lomutoPartioning (ArrayList<Integer> arr, int left, int right){
        int pivot = arr.get(right);  // Last element as pivot
        int i = left;        // Index of smaller element

        for (int j = left; j < right; j++) {
            if (arr.get(j) <= pivot) {  // Changed < to <= for stability
                i++;
                Collections.swap(arr, i, j);
            }
        }

        // Place pivot in correct position
        Collections.swap(arr, i, right);
        return i + 1;
    }
    public static void hoarePartioning(){

    }
    public int maxCoins(int[] piles) {
        // Sort the array in descending array

        // add the

        int n = piles.length;
        Arrays.sort(piles);
        return 0;

    }

    public static ArrayList<Integer> arrangeOddEven(ArrayList<Integer> arr){
        int initialEvenPos = 0;
        int i = 0;
        while(i < arr.size()){
            if(arr.get(i)% 2 == 0) {
                int temp = arr.get(initialEvenPos);
                arr.set(initialEvenPos, arr.get(i));
                arr.set(i, temp);
                initialEvenPos++;
            }
            i++ ;
        }
        return arr;

    }

    public static ArrayList<Integer> mergeArrays(ArrayList<Integer> first, ArrayList<Integer> second){

        int m = first.size();
        int n = second.size() / 2;
        int i = m - 1;
        int j = n - 1;
        int k = second.size() - 1;

        while (j >= 0) {
            if (i >= 0 && first.get(i) >= second.get(j)) {
                second.set(k, first.get(i));
                i--;
            } else {
                second.set(k, second.get(j));
                j--;
            }
            k--;
        }

        while (i >= 0) {
            second.set(k, first.get(i));
            i--;
            k--;
        }

        return second;

    }

    public static ArrayList<Character> dutchNationalFlag() {

        ArrayList<Character> balls = new ArrayList<>(Arrays.asList(
                'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'));

        int low = 0;        // Next position for 'R'
        int mid = 0;        // Current element to check
        int high = balls.size() - 1;  // Next position for 'B'

        while (mid <= high) {
            if (balls.get(mid).equals('R')) {
                // Red → swap with low, advance both
                Collections.swap(balls, low, mid);
                low++;
                mid++;
            }
            else if (balls.get(mid).equals('G')) {
                // Green → already correct, just advance mid
                mid++;
            }
            else { // "B"
                // Blue → swap with high, decrement high (don't advance mid)
                Collections.swap(balls, mid, high);
                high--;
            }
        }
        return balls;
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        int value = arr.get(n - 1);
        int i;
        for (i = n - 2; i >= 0 && arr.get(i) > value; i--) {
            arr.set(i + 1, arr.get(i));
            printArray(arr);
        }
        arr.set(i + 1, value);
        printArray(arr);
    }

    public static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int value = arr.get(i);//arr[i];
            int j = i - 1;
            while (j >= 0 && arr.get(j) > value) {
                arr.set((j + 1), arr.get(j));
                j--;
            }
            arr.set((j + 1), value);
            printArray(arr);  // Print after each full insertion
        }
    }
}
