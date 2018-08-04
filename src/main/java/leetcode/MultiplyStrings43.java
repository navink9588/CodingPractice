package leetcode;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * Imp.
 */
public class MultiplyStrings43 {

    // Solution - https://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
    private String multiplyStrings(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j < n2.length(); j++){
                d[i+j] += Character.getNumericValue(n1.charAt(i)) * Character.getNumericValue(n2.charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings43 m = new MultiplyStrings43();
        String s1 = "123456789";
        String s2 = "987654321";

        String result = m.multiplyStrings(s1, s2);
        System.out.printf("%s * %s = %s\n", s1, s2, result);

        s1 = "123";
        s2 = "456";

        result = m.multiplyStrings(s1, s2);
        System.out.printf("%s * %s = %s\n", s1, s2, result);
    }

}
