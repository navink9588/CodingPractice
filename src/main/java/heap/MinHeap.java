package heap;

/**
 * @author Navin Kumar
 * @date 6/26/18
 */
public class MinHeap {

    private static final Integer MAX_SIZE = 10;

    private int count = 0;
    private int[] heap = new int[MAX_SIZE];

    public void add(int v) {
        heap[count] = v;
        heapify();
        count++;
    }

    private void heapify() {
        int cur = count;
        while (cur > 0 && heap[cur] < heap[parentIndex(cur)]) {
            int tmp = heap[cur];
            heap[cur] = heap[parentIndex(cur)];
            heap[parentIndex(cur)] = tmp;
            cur = parentIndex(cur);
        }
    }

    private int parentIndex(int i) {
        return (i - 1)/2;
    }

    private int leftChild(int i) {
        return 2*i+1;
    }

    private int rightChild(int i) {
        return 2*i+2;
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < count; i++) {
            builder.append(heap[i]);
            if(leftChild(i) < count)
                builder.append(" -l- ").append(heap[leftChild(i)]);
            if(rightChild(i) < count)
                builder.append(" -r- ").append(heap[rightChild(i)]);
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(3);
        minHeap.add(9);
        minHeap.add(12);
        minHeap.add(7);
        minHeap.add(1);
        System.out.println(minHeap.toString());
    }
}
