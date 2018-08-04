package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 6/22/18
 *
 * https://stackoverflow.com/questions/39171403/cell-complete-problems
 */
public class Colony {
    private static int[] cellCompete(int[] cell, int day) {
        int[] ar = new int[10];
        for(int i=1; i<9; i++) {
            ar[i] = cell[i-1];
        }
        while(day-- > 0) {
            int temp = 0;
            for(int i=1; i<9; i++) {
                if(Math.abs(temp-ar[i+1])==1) {
                    temp = ar[i];
                    ar[i] = 1;
                }
                else {
                    temp = ar[i];
                    ar[i] = 0;
                }
            }
        }
        System.arraycopy(ar, 1, ar, 0, 8);
        return ar;
    }

    public static void main(String[] args) {

        int[] cell = {0, 1, 0, 1, 0, 1, 0, 1}; // {1,0,1,1,0,1,0,1};
        int day = 3;
        cell = cellCompete(cell, day);
        for(int i=0; i<8; i++) {
            System.out.print(cell[i]+" ");
        }
    }

    public static List<String> logProcessor (List<String> list){
        List<String> strAlp = new ArrayList<String>();
        List<String> strNum = new ArrayList<String>();
        List<String> AlpNum = new ArrayList<String>();

        for( String sl :  list){
            String[] slPart = sl.split(" ", 2);
            if(Character.isDigit(slPart[1].charAt(0))){
                strNum.add(sl);
            }
            else {
                strAlp.add(slPart[1].concat(" " + slPart[0]));
            }
        }
        Collections.sort(strAlp);
        for(String sl2 : strAlp){
            String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
            AlpNum.add(part[1].concat(" " + part[0]));
        }
        AlpNum.addAll(strNum);
        return AlpNum;
    }
}
