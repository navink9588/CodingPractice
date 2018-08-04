package amazon;

/**
 * @author Navin Kumar
 * @date 7/12/18
 *
 * Technical Ph interview question
 *
 * Write a cipher function that encrypts a given string by rotating each
 * character by the given integer.
 *
 * Examples:
 * "a", 1 -> "b"
 * "fs", 3 -> "iv"
 * "z", 1 -> "a"
 * "Z", 1 -> "A"
 * "a", 26 -> "a"
 * "a", -1 -> "z"
 */
public class Encrypter {

    private static final Integer UPPER_CASE_LOWER_BOUND = 65;
    private static final Integer UPPER_CASE_UPPER_BOUND = 90;
    private static final Integer LOWER_CASE_LOWER_BOUND = 97;
    private static final Integer LOWER_CASE_UPPER_BOUND = 122;
    private static final Integer TOTAL_LETTERS = 26;

    private String encrypt(String message, int rotation) {
        if(message == null || message.isEmpty() || rotation == 0)
            return message;

        rotation = rotation % TOTAL_LETTERS;
        if(rotation == 0) return message;

        StringBuilder builder = new StringBuilder();
        int lowerBound, upperBound;
        for(char ch : message.toCharArray()) {
            if(Character.isLetter(ch)) {
                if(Character.isUpperCase(ch)) {
                    lowerBound = UPPER_CASE_LOWER_BOUND;
                    upperBound = UPPER_CASE_UPPER_BOUND;
                } else {
                    lowerBound = LOWER_CASE_LOWER_BOUND;
                    upperBound = LOWER_CASE_UPPER_BOUND;
                }

                int val = (int) ch + rotation;
                if(val > upperBound) {
                    val -= TOTAL_LETTERS;
                } else if (val < lowerBound) {
                    val += TOTAL_LETTERS;
                }
                ch = (char) val;
            }
            builder.append(ch);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Encrypter encrypter = new Encrypter();
        String message = null;
        int rotation = 1;
        String encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "";
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "abc";
        rotation = 0;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "123";
        rotation = 1;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "abc12-$";
        rotation = 1;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "aTcG12-$";
        rotation = 1;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "AZct86#";
        rotation = 2601;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "AZct86#";
        rotation = -2601;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);

        message = "abc";
        rotation = 52;
        encrypted = encrypter.encrypt(message, rotation);
        System.out.printf("Original: %s, Encrypted: %s\n", message, encrypted);
    }

}
