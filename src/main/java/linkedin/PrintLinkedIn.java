package linkedin;

/**
 * @author Navin Kumar
 * @date 7/5/18
 *
 * https://www.careercup.com/question?id=6260502941401088
 */
public class PrintLinkedIn {

    private void printLinkedIn(int n) {
        if(n == 0) return;

        String str = "";
        if(n % 4 == 0) str = "Linked";
        if(n % 6 == 0) str += "in";
        System.out.printf("%d: %s\n", n, str);
    }

    public static void main(String[] args) {
        PrintLinkedIn printLinkedIn = new PrintLinkedIn();
        printLinkedIn.printLinkedIn(3);
        printLinkedIn.printLinkedIn(4);
        printLinkedIn.printLinkedIn(6);
        printLinkedIn.printLinkedIn(12);
    }

}
