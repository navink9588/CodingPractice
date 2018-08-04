package linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * http://mathforum.org/library/drmath/view/55812.html
 *
 * Given a number n that represents n lockers and n students. All lockers start closed.
 * First student goes and opens all the lockers. 2nd goes and toggles 2nd, 4th, 6th ... lockers.
 * 3rd student toggles 3rd, 6th, 9th ... lockers. Print the lockers that remain open after
 * all students pass.
 *
 * If a number is a perfect square it will have an odd number of factors,
 * e.g 4 has factors 1, 2, 4, whereas all other numbers have an even
 * number of factors.  If a particular locker is visited an odd number of
 * times it will be open at the end of the procedure you describe;
 * otherwise it will be closed.
 *
 * To just find the number of lockers opened, find the biggest perfect
 * square closest to n. E.g., n = 10, biggest perfect square is 9, a
 * square of 3. So there are 3 open lockers i.e., 1, 4, 9. Similarly, for n = 100,
 * square of 10 is 100, so 10 lockers are open i.e., 1, 4, 9, 16, 25, 36, 49, 64, 81, 100.
 */
public class Locker {

    private void printOpen(int n) {
        if(n == 0) {
            return;
        }

        List<Integer> open = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            double sqrt = Math.sqrt(i);
            if(sqrt - Math.floor(sqrt) == 0) {
                open.add(i);
            }
        }

        System.out.println("Open Lockers : " + open);
        System.out.println("Total number of open lockers : " + open.size());
    }

    public static void main(String[] args) {
        Locker locker = new Locker();
        locker.printOpen(1000);
    }
}
