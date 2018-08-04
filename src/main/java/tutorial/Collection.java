package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author FogHorn Systems, Inc.
 */
public class Collection {
    public void filter(java.util.Collection<Integer> collection, int n) {
        for(Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
            if(iterator.next() < n) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Collection collection = new Collection();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        Set<Integer> set = new HashSet<>(list);
        collection.filter(list, 4);
        collection.filter(set, 5);
        System.out.println(list);
        System.out.println(set);
        System.out.println("Contains all: " + list.containsAll(set));
        list.retainAll(set);
        System.out.println(list);
        Integer[] integers = list.toArray(new Integer[0]);
        for(int i : integers) {
            System.out.print(i + " ");
        }
        System.out.println();
        Collections.shuffle(list, new Random());
        System.out.println("Post shuffle: " + list);
    }
}
