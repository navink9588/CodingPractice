package linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FogHorn Systems, Inc.
 */
public class MinDistance2 {

    private Map<String, Map<String, Integer>> minDistance;

    public MinDistance2(List<String> words) {
        minDistance = new HashMap<>();
        int n = words.size();
        for(int i = 0; i < n; i++) {
            String key = words.get(i);
            Map<String, Integer> value;
            if(minDistance.containsKey(key)) {
                value = minDistance.get(key);
            } else {
                value = new HashMap<>();
                minDistance.put(key, value);
            }
            for(int j = 0; j < n; j++){
                if(i !=j ) {
                    String word = words.get(j);
                    int distance = Math.abs(j - i);
                    if(!value.containsKey(word) || value.get(word) > distance) {
                        value.put(word, distance);
                    }
                }
            }
        }
    }

    public int minDistance(String wordOne, String wordTwo) {
        return minDistance.containsKey(wordOne) ?
            (minDistance.get(wordOne).containsKey(wordTwo) ?
                (minDistance.get(wordOne).get(wordTwo)) : -1 )
            : -1;
    }

    public static void main(String[] args) {
        MinDistance2 minDistance2 = new MinDistance2(Arrays.asList("the", "quick", "brown", "fox", "quick"));
        System.out.println(minDistance2.minDistance("quick", "fox"));
        System.out.println(minDistance2.minDistance("quick", "brown"));
        System.out.println(minDistance2.minDistance("the", "fox"));
    }
}
