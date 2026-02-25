import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ArraysAndStrings {
    public static void main(String[] args) {
        //System.out.println(checkIfPalindroma("aceba"));

        int[] input1= {2,7,11,15};
        //System.out.println(twoSum(input1 , 9).toString());

        int[] input2 = {1,8,6,2,5,4,8,3,7};
        //maxArea(input2);
        Character[] myChars = {'a', 's', 'd', 'f', 'g', '*', '&', '!', 'z', 'y'};
        List<Character> characterList = Arrays.asList(myChars);
        //List<Integer> arrayRotation = Arrays.stream(input2).boxed().collect(Collectors.toList());
        //System.out.println(rotateLeft(15, arrayRotation));
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.addAll(characterList);
        System.out.println(sort_array(arrayList));

    }
    public static boolean checkIfPalindroma(String s){
        int i = 0, j = s.length()-1;
        while(i< j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length -1;

        while(i < j){
            int sum = numbers[i] + numbers[j];
            if (sum == target){
                result[0] = i+1;
                result[1] = j +1;
                break;
            }
            if(sum < target){
                i++;
            }
            if(sum > target){
                j--;
            }
        }
        return result;
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length; // Array of smaller length  10 5
        int n = nums2.length; // Array of smaller length 50  25
        int left = 0, right = m;

        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        return 0.0;
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxA = 0;

        while (left < right) {
            int leftH = height[left];
            int rightH = height[right];
            int h = Math.min(leftH, rightH);
            int width = right - left;
            maxA = Math.max(maxA, h * width);

            // Move the pointer with smaller height
            if (leftH < rightH) {
                // skip all heights <= leftH
                while (left < right && height[left] <= leftH) {
                    left++;
                }
            } else {
                // skip all heights <= rightH
                while (left < right && height[right] <= rightH) {
                    right--;
                }
            }
        }
        System.gc();
        return maxA;
    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        d = d % n;
        List<Integer> rotated = new ArrayList<>((arr.subList(d, n)));
        rotated.addAll(arr.subList(0, d));
        return rotated;
    }
    public static long aVeryBigSum(List<Long> ar) {
        long sum = 0;
        for (long i : ar) {
            sum += i;
        }
        return sum;
    }
    public double findMedianSortedArrays2(int[] a, int[] b) {
        // Get sizes of both arrays
        int n1 = a.length, n2 = b.length;

        // Total size
        int n = n1 + n2;

        // Median indices
        int ind2 = n / 2;
        int ind1 = ind2 - 1;

        // Initialize pointers and values
        int cnt = 0, i = 0, j = 0;
        int ind1el = -1, ind2el = -1;

        // Merge step to find median
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                j++;
            }
            cnt++;
        }

        // Remaining elements in a
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }

        // Remaining elements in b
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        // Return median
        if (n % 2 == 1) return (double) ind2el;
        return (ind1el + ind2el) / 2.0;
    }

    public static String getTruncatedString(String input, String toRemove){
        StringBuilder sb = new StringBuilder(input);
        int index = sb.indexOf(toRemove);
        while (index != -1) {
            sb.delete(index, index + toRemove.length());
            // Find the next occurrence from the current position
            index = sb.indexOf(toRemove, index);
        }
        return  sb.toString();
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return  dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (start == s.length()) {
            return Arrays.asList("");  // Base case: empty string
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> res = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> sublist = dfs(s, end, wordSet, memo);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }
        memo.put(start, res);
        return res;
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1] ||
                !sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }

        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;

        return countShips(sea, topRight, new int[]{midX + 1, midY + 1}) +
                countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
                countShips(sea, new int[]{midX, midY}, bottomLeft) +
                countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);

        return mergeTwoLists(l1, l2);
    }

    // Standard merge 2 sorted lists (LeetCode 21)
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static ArrayList<Character> sort_array(ArrayList<Character> arr) {
        // Write your code here.
        arr.sort((a, b) ->a.compareTo(b));
        return arr;
    }

    public static Long find_integer(ArrayList<Long> arr) {
        int size = (int)((Math.pow(2, 32)) / 8);
        byte[] bytes = new byte[size]; // Initialized with zeros by the JVM.
        for(long inputValue : arr) {
            int byteIndex = (int) (inputValue / 8);
            int bitIndex = (int) (inputValue % 8);
            // Set the bit corresponding to inputValue:
            bytes[byteIndex] |= 1 << bitIndex;
        }
        for(int byteIndex = 0; byteIndex < size; byteIndex++) {
            for(int bitIndex = 0; bitIndex < 8; bitIndex++) {
                if((bytes[byteIndex] & (1 << bitIndex)) == 0) {
                    // As soon as we have found the first unset bit,
                    // return the number corresponding to that bit.
                    return byteIndex * 8L + bitIndex;
                }
            }
        }
        throw new IllegalStateException(
                "Must have found an unset bit and returned from the loop");

    }

}
