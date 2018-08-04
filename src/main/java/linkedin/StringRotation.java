package linkedin;

import java.util.Scanner;

/**
 * LinkedIn
 * https://www.careercup.com/question?id=5766535168655360
 */
public class StringRotation {

    public static boolean isRotation(String str1, String str2) {
        String tmp = str1 + str1;
        return tmp.contains(str2);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String original, test;
        System.out.println("Enter original string : ");
        original = scanner.next();
        System.out.println("Enter test string : ");
        test = scanner.next();

        System.out.printf("%s is rotated from %s : %s\n", test, original, isRotation(test, original));
    }

}
