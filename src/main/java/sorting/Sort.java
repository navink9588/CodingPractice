package sorting;

/**
 * @author FogHorn Systems, Inc.
 */
public abstract class Sort {
    public abstract void sort(int[] input);

    public String toString(int[] input) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i : input) {
            builder.append(" ")
                .append(i);
        }
        builder.append(" ]");

        return builder.toString();
    }
}
