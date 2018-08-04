package bitmanipulations;

/**
 * @author Navin Kumar
 * @date 7/14/18
 */
public class PrintBinary {

    private static final String ERROR = "Error";

    private String printBinary(double num) {
        if(num >= 1 || num <=0)
            return ERROR;

        StringBuilder builder = new StringBuilder();
        builder.append(".");
        double fraction = 0.5;
        while (num > 0) {
            if(builder.length() > 32)
                return ERROR;
            if(num >= fraction) {
                builder.append(1);
                num -= fraction;
            } else {
                builder.append(0);
            }
            fraction /= 2;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PrintBinary binary = new PrintBinary();
        double num = 0.75;
        String str = binary.printBinary(num);
        System.out.printf("Binary of %f: %s\n", num, str);

        num = 0.625;
        str = binary.printBinary(num);
        System.out.printf("Binary of %f: %s\n", num, str);
    }
}
