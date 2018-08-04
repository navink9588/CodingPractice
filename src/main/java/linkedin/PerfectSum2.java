package linkedin;

import java.util.HashSet;

/**
 * https://stackoverflow.com/questions/18305843/find-all-subsets-that-sum-to-a-particular-value
 */
public class PerfectSum2 {
    private HashSet<String> set = new HashSet<>();
    private final String separator = " ";

    public void findAllSets(int[] arr, int sum, String ramp, int index) {
        if(index > arr.length - 1) {
            if(getSum(ramp) == sum){
                set.add(ramp);
            }
            return;
        }

        //First recursive call going ahead selecting the int at the current index value
        findAllSets(arr, sum, ramp + arr[index] + separator, index + 1);
        //Second recursive call going ahead WITHOUT selecting the int at the current index value
        findAllSets(arr, sum, ramp, index + 1);
    }

    private int getSum(String ramp) {
        int sum = 0;
        if(!ramp.equals("")) {
            for(String str : ramp.split(separator)) {
                sum += Integer.valueOf(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        PerfectSum2 perfectSum2 = new PerfectSum2();
        int[] arr = {2, 3, 1, 5, 6, 8, 10};
        int sum = 10;

        perfectSum2.findAllSets(arr, sum, "", 0);

        perfectSum2.set.forEach(System.out::println);
    }
}
