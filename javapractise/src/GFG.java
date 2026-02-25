import java.util.*;

public class GFG {

    public static void main(String[] args) {
        String s = "[({)(})]{}";
        System.out.println((isBalanced(s) ? "true" : "false"));
    }
    public static boolean isBalanced(String s) {
        // Stack LIFO

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // No opening bracket
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void whatFlavors(List<Integer> cost, int money) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < cost.size(); i++) {
            int c = cost.get(i);
            int complement = money - c;
            if (seen.containsKey(complement)) {
                int firstIndex = seen.get(complement); // already 1-based
                int secondIndex = i + 1;               // convert to 1-based
                System.out.println(firstIndex + " " + secondIndex);
                return; // unique solution, so we can exit
            }
            if (!seen.containsKey(c)) {
                seen.put(c, i + 1);
            }
        }
    }
    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {
        // Write your code here.
        Map<Integer, Integer> seen = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int c = numbers.get(i);
            int complement = target - c;
            if (seen.containsKey(complement)) {
                res.add(seen.get(complement));
                res.add(i);
                break;
            }
            if (!seen.containsKey(c)) {
                seen.put(c, i);
            }
        }
        if (res.isEmpty()){
            res.add(-1);
            res.add(-1);
        }
        return res;
    }
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shrink prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
