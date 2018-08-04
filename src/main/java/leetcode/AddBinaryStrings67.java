package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * My own solution
 */
public class AddBinaryStrings67 {

    private String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        int n = a.length();
        int m = b.length();

        int i = n - 1;
        int j = m - 1;
        char carry = '0';
        while (i >= 0 || j >= 0) {
            char ach = i >= 0 ? a.charAt(i) : '0';
            char bch = j >= 0 ? b.charAt(j) : '0';
            i--; j--;

            if(ach == '1' && bch == '1') {
                if(carry == '1') {
                    builder.insert(0, '1');
                } else {
                    builder.insert(0, '0');
                }
                carry = '1';
            } else if(ach == '1' || bch == '1') {
                if(carry == '1') {
                    builder.insert(0, '0');
                    carry = '1';
                } else {
                    builder.insert(0, '1');
                    carry = '0';
                }
            } else {
                if(carry == '1') {
                    builder.insert(0, '1');
                } else {
                    builder.insert(0, '0');
                }
                carry = '0';
            }
        }

        if(carry == '1') {
            builder.insert(0, '1');
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        AddBinaryStrings67 add = new AddBinaryStrings67();
        String a = "1010";
        String b = "1011";
        String sum = add.addBinary(a, b);
        System.out.printf("%s + %s = %s\n", a, b, sum);

        a = "11";
        b = "1";
        sum = add.addBinary(a, b);
        System.out.printf("%s + %s = %s\n", a, b, sum);

        a = "0";
        b = "0";
        sum = add.addBinary(a, b);
        System.out.printf("%s + %s = %s\n", a, b, sum);
    }

}
