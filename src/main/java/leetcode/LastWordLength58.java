package leetcode;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * My own solution
 */
public class LastWordLength58 {

    private int lengthOfLastWord(String s) {
        if(s == null || s.isEmpty())
            return 0;

        String r = new StringBuilder(s).reverse().toString();
        r = r.trim();

        int firstSpaceIndex = r.indexOf(' ');
        if(firstSpaceIndex == -1) return r.length();

        return r.substring(0, firstSpaceIndex).length();
    }

    public static void main(String[] args) {
        LastWordLength58 len = new LastWordLength58();
        String s = "a ";
        System.out.printf("Word: '%s', Len: %d", s, len.lengthOfLastWord(s));

        s = "Hello World     ";
        System.out.printf("Word: '%s', Len: %d", s, len.lengthOfLastWord(s));
    }

}
