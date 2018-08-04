package dynamic.programming;

import java.util.Arrays;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/15/18
 *
 * Google Problem
 *
 * https://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 */
public class WordBreak {

    // Solution from here -
    // https://www.programcreek.com/2012/12/leetcode-solution-word-break/
    private boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] pos = new boolean[n+1];

        pos[0] = true;

        for(int i=0; i<n; i++){
            if(pos[i]){
                for(int j=i+1; j<=n; j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j] = true;
                    }
                }
            }
        }

        return pos[n];
    }

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("mobile","samsung","sam","sung","man","mango",
            "icecream","and","go","i","like","ice","cream");
        WordBreak wb = new WordBreak();
        String word = "ilikesamsung";
        System.out.printf("WB of %s possible: %b\n", word, wb.wordBreak(word, dictionary));
        word = "likecreamnsamsung";
        System.out.printf("WB of %s possible: %b\n", word, wb.wordBreak(word, dictionary));
    }

}
