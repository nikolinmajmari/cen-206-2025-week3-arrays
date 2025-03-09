package arrays;

import java.util.HashMap;
import java.util.Map;

public class Histogram {

    static Map<Integer,Integer> getHistogram(int[] array){
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       // todo your code here
       return map;
    }

    public static void main(String[] args) {
        System.out.println(getHistogram(new int[]{1,1,2,4,3,1,2,5,6,4,2,3,1}));
        /// {1=4, 2=3, 3=2, 4=2, 5=1, 6=1}
    }
}
