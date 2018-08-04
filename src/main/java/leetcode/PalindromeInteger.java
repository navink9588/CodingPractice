package leetcode;

/**
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeInteger {

    private boolean isPalindrome(int n) {
        if(n >= 0 && n < 10) return true;
        if(n < 0 || n % 10 == 0) return false;

        int nReverse = 0;
        while (nReverse < n) {
            nReverse = (nReverse * 10) + (n % 10);
            n /= 10;
        }

        return n == nReverse || n == nReverse/10;
    }

    public static void main(String[] args) {
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        System.out.println("121 = " + palindromeInteger.isPalindrome(121));
        System.out.println("12321 = " + palindromeInteger.isPalindrome(12321));
        System.out.println("-121 = " + palindromeInteger.isPalindrome(-121));
        System.out.println("10 = " + palindromeInteger.isPalindrome(10));
        System.out.println("1 = " + palindromeInteger.isPalindrome(1));
    }
}
