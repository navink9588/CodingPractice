import java.util.Stack;

/**
 * @author FogHorn Systems, Inc.
 */
public class Hanoi {

    private void move(int n, Stack<Integer> origin, Stack<Integer> destination,
        Stack<Integer> buffer) {
        if(n >= 0) {
            move(n-1, origin, buffer, destination);
            destination.push(origin.pop());
            move(n-1, buffer, destination, origin);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        Stack<Integer> destination = new Stack<>();

        int n = 2;
        for(int i = 0; i <= n; i++) {
            origin.push(i);
        }

        System.out.println("*** Before move ***");
        System.out.println("Origin : " + origin);
        System.out.println("Buffer : " + buffer);
        System.out.println("Destination: " + destination);

        hanoi.move(n, origin, destination, buffer);

        System.out.println("*** After move ***");
        System.out.println("Origin : " + origin);
        System.out.println("Buffer : " + buffer);
        System.out.println("Destination: " + destination);
    }

}
