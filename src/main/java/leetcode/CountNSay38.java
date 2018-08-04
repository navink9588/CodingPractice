package leetcode;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/count-and-say/description/
 */
public class CountNSay38 {

    // Solution - https://www.programcreek.com/2014/03/leetcode-count-and-say-java/
    private String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNSay38 countNSay38 = new CountNSay38();
        String r = countNSay38.countAndSay(5);
        System.out.println(r);
    }

}
