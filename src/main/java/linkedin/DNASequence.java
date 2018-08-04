package linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Navin Kumar
 * @date 7/13/18
 *
 * LinkedIn problem
 *
 * Doesn't work
 */
public class DNASequence {

    private static final Map<Character, Integer> SEQ_TO_VAL = new HashMap<>();
    private static final Map<Integer, Character> VAL_TO_SEQ = new HashMap<>();
    private static final Integer BASE = 4;
    private static final Integer DNA_SEQ_SIZE = 10;

    static {
        SEQ_TO_VAL.put('A', 1);
        SEQ_TO_VAL.put('C', 2);
        SEQ_TO_VAL.put('G', 3);
        SEQ_TO_VAL.put('T', 4);

        VAL_TO_SEQ.put(1, 'A');
        VAL_TO_SEQ.put(2, 'C');
        VAL_TO_SEQ.put(3, 'G');
        VAL_TO_SEQ.put(4, 'T');
    }

    private void printRepeatedSequences(String sequences) {
        Set<Integer> sequencesSeen = new HashSet<>();
        TreeSet<Integer> repeatedSequences = new TreeSet<>();

        int count = 0;
        int hash = 0;
        for(char ch : sequences.toCharArray()) {
            hash = hash << 2;
            hash += SEQ_TO_VAL.get(ch);
            count++;
            if(count == DNA_SEQ_SIZE) {
                if(sequencesSeen.contains(hash))
                    repeatedSequences.add(hash);
                else
                    sequencesSeen.add(hash);
                count--;
                hash = hash % (int) Math.pow(BASE, count);
            }
        }

        System.out.println(sequencesSeen);
        System.out.println(repeatedSequences);

        for(Integer seq : repeatedSequences) {
            StringBuilder builder = new StringBuilder();
            count = 9;
            while (count > 0) {
                int val = seq/count;
                int div = (int) Math.pow(BASE, count);
                val = val / div;
                seq = seq % div;
                builder.append(VAL_TO_SEQ.get(val));
                count--;
            }
            builder.append(VAL_TO_SEQ.get(seq));
            System.out.println(builder.toString());
        }
    }

    public static void main(String[] args) {
        String seq = "AGCTTTGCACCAGTCGATAGCTTTGCACTGCACCAGTCGATAGCTTTG";
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.printRepeatedSequences(seq);
    }

}
