package graph;

import java.util.Arrays;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 6/14/18
 *
 * https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 */
public class Boggle {

    private List<String> dictionary;

    public Boggle() {
        dictionary = Arrays.asList("GEEKS", "FOR", "QUIZ", "GO");
    }

    private void findWords(char[][] chars) {
        int m = chars.length;
        int n = chars[0].length;
        boolean visited[][] = new boolean[m][n];

        String str = "";

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWordUtil(chars, visited, i, j, str);
            }
        }
    }

    private void findWordUtil(char[][] chars, boolean visited[][], int i, int j, String str) {
        visited[i][j] = true;
        str += chars[i][j];

        if(dictionary.contains(str)) {
            System.out.println("Found word: " + str);
        }

        for(int k = i-1; k <= i+1 && k < chars.length; k++) {
            for(int l = j-1; l <= j+1 && l < chars[0].length; l++) {
                if(k >=0 && l >=0 && !visited[k][l]) {
                    findWordUtil(chars, visited, k, l, str);
                }
            }
        }

        str = str.substring(0, str.length() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] chars = {
            {'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}
        };

        Boggle boggle = new Boggle();
        boggle.findWords(chars);
    }
}
