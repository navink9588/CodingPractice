package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Imp.
 *
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZag {

    private String zigZag(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int cur = 0;
        boolean down = false;

        for(char c : s.toCharArray()) {
            list.get(cur).append(c);
            if(cur == 0 || cur == numRows - 1)
                down = !down;
            cur += down ? 1 : -1;
        }

        StringBuilder builder = new StringBuilder();
        for(StringBuilder b : list) {
            builder.append(b);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.zigZag("PAYPALISHIRING", 4));
    }


}
