package arrays;

import java.util.HashMap;
import java.util.Map;

public class Histogram {

    Map<Integer,Integer> getHistogram(int[] array){
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for(int i=0;i<array.length;i++){
           map.put(array[i],map.getOrDefault(array[i],0)+1);
       }
       return map;
    }

    public static void main(String[] args) {

    }
}
