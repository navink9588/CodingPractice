package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Navin Kumar
 * @date 7/5/18
 * https://www.careercup.com/question?id=5754648968298496
 *
 * My own solution
 */
public class CommonIngredients {

    private List<List<String>> common(Map<String, Set<String>> dishes) {
        List<List<String>> common = new ArrayList<>();
        List<String> dishNames = new ArrayList<>(dishes.keySet());
        int n = dishNames.size();
        for(int i = 0; i < n - 1; i++) {
            Set<String> dish1 = dishes.get(dishNames.get(i));
            for(int j = i + 1; j < n; j++) {
                Set<String> dish2 = new HashSet<>(dishes.get(dishNames.get(j)));
                dish2.retainAll(dish1);
                if(!dish2.isEmpty()) {
                    List<String> found = Arrays.asList(dishNames.get(i), dishNames.get(j));
                    common.add(found);
                }
            }
        }
        return common;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> dishes = new HashMap<>();

        Set<String> pasta = new HashSet<>();
        pasta.add("Tomato Sauce");
        pasta.add("Onions");
        pasta.add("Garlic");
        dishes.put("Pasta", pasta);

        Set<String> chickenCurry = new HashSet<>();
        chickenCurry.add("Chicken");
        chickenCurry.add("Curry Sauce");
        dishes.put("Chicken Curry", chickenCurry);

        Set<String> friedRice = new HashSet<>();
        friedRice.add("Rice");
        friedRice.add("Onions");
        friedRice.add("Nuts");
        dishes.put("Fried Rice", friedRice);

        Set<String> salad = new HashSet<>();
        salad.add("Spinach");
        salad.add("Nuts");
        dishes.put("Salad", salad);

        Set<String> sandwich = new HashSet<>();
        sandwich.add("Cheese");
        sandwich.add("Bread");
        dishes.put("Sandwich", sandwich);

        Set<String> quesadilla = new HashSet<>();
        quesadilla.add("Chicken");
        quesadilla.add("Cheese");
        dishes.put("Quesadilla", quesadilla);

        CommonIngredients commonIngredients = new CommonIngredients();
        List<List<String>> common = commonIngredients.common(dishes);
        System.out.println(common);
    }
}
