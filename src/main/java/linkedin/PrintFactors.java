package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.careercup.com/question?id=5759894012559360
 *
 * https://www.fitcoding.com/2014/09/15/print-all-sets-of-factors/
 */
public class PrintFactors {

    Set<String> factors = new HashSet<>();
    private void printFactors(int number)
    {
        if (number <= 1) {
            return;
        }

        // Print the first set of factors
        factors.add(number + " * 1");

        printFactorsHelper("", number, number);
        System.out.println("All factors: ");
        System.out.println(factors);
    }

    private void printFactorsHelper(String currExpression, int dividend, int previousFactor)
    {
        for (int factor = dividend - 1; factor > 1; --factor)
        {
            if (dividend % factor == 0 && factor <= previousFactor)
            {
                // found 2 factors
                int nextFactor = dividend / factor;

                // try printing only if second factor is smaller (i.e. descending order)
                if (nextFactor <= factor)
                {
                    factors.add(currExpression + factor + " * " + nextFactor);
                }

                printFactorsHelper(currExpression + factor + " * ", nextFactor, factor);
            }
        }

    }

    public static void main(String[] args) {
        PrintFactors printFactors = new PrintFactors();
        printFactors.printFactors(12);
    }
}
