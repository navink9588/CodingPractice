package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Navin Kumar
 * @date 6/25/18
 */
public class Reorder {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a1 Navin", "a2, 123", "b1 Kumar", "c1 ankur", "d0 564", "d1 rani", "d2 nancy", "d3 Apple");

        List<String> numeric = new ArrayList<>();
        TreeMap<String, Integer> ordered = new TreeMap<>();
        for(int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            String[] tokens = string.split(" ");
            if(Character.isDigit(tokens[1].charAt(0))) {
                numeric.add(string);
            } else {
                ordered.put(tokens[1] + " " + tokens[0], i);
            }
        }
        List<String> result = new ArrayList<>();
        for(Integer index : ordered.values()) {
            result.add(strings.get(index));
        }
        result.addAll(numeric);

        System.out.println(result);
    }

}
