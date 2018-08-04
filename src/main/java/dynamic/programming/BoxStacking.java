package dynamic.programming;

import java.util.Arrays;

/**
 * @author Navin Kumar
 * @date 7/15/18
 *
 * https://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 */
public class BoxStacking {

    private static final class Box implements Comparable<Box> {
        int h;
        int w;
        int d;
        private int area;

        Box(int h, int w, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
            this.area = this.w * this.d;
        }

        @Override
        public int compareTo(Box o) {
            return o.area - this.area;
        }
    }

    private int maxStackHeight(Box[] boxes) {
        int n = boxes.length;
        int r = n * 3;
        Box[] rot = new Box[r];

        for(int i = 0; i < n; i++) {
            Box box = boxes[i];
            rot[3*i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
            rot[3*i + 1] = new Box(box.w, Math.max(box.h, box.d), Math.min(box.h, box.d));
            rot[3*i + 2] = new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
        }

        Arrays.sort(rot);
        int msh[] = new int[r];
        for(int i = 0; i < r; i++) {
            msh[i] = rot[i].h;
        }

        for(int i = 1; i < r; i++){
            Box box = rot[i];
            int val = 0;

            for(int j = 0; j < i; j++){
                Box prevBox = rot[j];
                if(box.w < prevBox.w && box.d < prevBox.d){
                    val = Math.max(val, msh[j]);
                }
            }
            msh[i] = val + box.h;
        }

        int max = -1;

        /* Pick maximum of all msh values */
        for(int i = 0; i < r; i++){
            max = Math.max(max, msh[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        BoxStacking bs = new BoxStacking();

        Box[] boxes = {
            new Box(4,6,7),
            new Box(1,2,3),
            new Box(4,5,6),
            new Box(10,12,32),
        };

        int max = bs.maxStackHeight(boxes);
        System.out.println("Max stack height possible: " + max);
    }

}
