public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] first = {1, 3, 5};     // nums2, n=3
        int[] second = {2, 4, 6, 0, 0, 0};  // nums1, m=3 (length 6)
        merge(second, 3, first, 3);
        System.out.println(java.util.Arrays.toString(second));  // [1,2,3,4,5,6]
    }
}