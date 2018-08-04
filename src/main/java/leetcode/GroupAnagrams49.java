package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Navin Kumar
 * @date 7/21/18
 * https://leetcode.com/problems/group-anagrams/solution/
 */
public class GroupAnagrams49 {

    // O(N*K*Log(K)) where N is the length of strings, and K is the maximum length
    // of a string in strings. The outer loop has complexity O(N) as we iterate
    // through each string. Then, we sort each string in O(K*Log(K)) time.
    private List<List<String>> group(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String s : strings) {
            String sorted = sort(s);
            if(!groups.containsKey(sorted))
                groups.put(sorted, new ArrayList<>());
            groups.get(sorted).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    private String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }

    //----------------------------------------------------------------------------
    // O(NK), where N is the length of strs, and K is the maximum length of a string
    // in strs. Counting each string is linear in the size of the string, and we
    // count every string.

    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams49 ana = new GroupAnagrams49();
        List<List<String>> groups = ana.group(strings);
        System.out.println("First approach: " + groups);

        groups = ana.groupAnagrams(strings);
        System.out.println("Second approach: " + groups);
    }

}
