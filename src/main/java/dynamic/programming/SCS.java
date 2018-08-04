package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/15/18
 * Shortest Common Super sequence
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 */
public class SCS {

    private int scs(String a, String b) {
        LCS lcs = new LCS();
        int l = lcs.lcsLength(a, b);
        return a.length() + b.length() - l;
    }

    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        SCS scs = new SCS();
        System.out.printf("SCS of %s, %s: %d\n", a, b, scs.scs(a, b));
        a = "geek";
        b = "eke";
        System.out.printf("SCS of %s, %s: %d\n", a, b, scs.scs(a, b));
    }

}
