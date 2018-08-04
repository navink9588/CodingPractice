package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Navin Kumar
 * @date 6/20/18
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstring {

    private int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if(characters.contains(ch)) {
                break;
            }
            characters.add(ch);
        }
        return characters.size();
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
    }
}
