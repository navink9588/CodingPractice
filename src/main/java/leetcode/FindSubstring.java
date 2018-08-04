package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/6/18
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * My own solution. So proud :)
 */
public class FindSubstring {

    private List<Integer> findSubstring(String string, String[] words) {
        List<Integer> indices = new ArrayList<>();

        if(string == null || string.isEmpty()) return indices;
        if(words == null || words.length == 0) return indices;
        int n = words[0].length();
        if(string.length() < words.length * n) return indices;

        List<String> list = Arrays.asList(words);
        for(int i = 0; i < string.length() - n; i++) {
            List<String> copy = new ArrayList<>(list);
            String sub = string.substring(i, i+n);
            if(copy.contains(sub)) {
                copy.remove(sub);
                int j = i;
                while (!copy.isEmpty()) {
                    j = j+n;
                    if(j > string.length() || j + n > string.length()) break;
                    sub = string.substring(j, j+n);
                    if(copy.contains(sub))
                        copy.remove(sub);
                    else
                        break;
                }

                if(copy.isEmpty())
                    indices.add(i);
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        String string = "barfoothefoobarman";
        String[] words = {"foo","bar", "man"};

        List<Integer> indices = findSubstring.findSubstring(string, words);
        System.out.println(indices);

        string = "wordgoodstudentgoodword";
        String[] words2 = {"word","student"};
        indices = findSubstring.findSubstring(string, words2);
        System.out.println(indices);

        string = "barfoofoobarthefoobarman";
        String[] w3 = {"bar","foo","the"};
        indices = findSubstring.findSubstring(string, w3);
        System.out.println(indices);
    }

}
