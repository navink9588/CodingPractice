package linkedin;

/**
 * @author FogHorn Systems, Inc.
 */
public class Sqrt {

    private double sqrt(double x) {
        if(x <= 1) {
            return x;
        }
        return sqrt(x, 1);
    }

    private double sqrt(double x, double g) {
        if (closeEnough(g, x/g))
            return g;
        else
            return sqrt(x, betterGuess(x, g));
    }

    private boolean closeEnough(double a, double b) {
        return (Math.abs(a - b) < .001);
    }

    private double betterGuess(double x, double g) {
        return ((g + x/g) / 2);
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        for(int i = 1; i < 5; i++) {
            System.out.println("Sqrt of " + i + " = " + sqrt.sqrt(i));
        }
    }
}
