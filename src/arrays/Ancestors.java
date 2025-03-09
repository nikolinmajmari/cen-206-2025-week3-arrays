package arrays;

import java.util.ArrayList;
import java.util.List;

public class Ancestors {


    public static List<String> findAncestors(String [][] array,String person){
        if(array.length==0){
            return new ArrayList<>();
        }
        List<String> parents = new ArrayList<String>();
        for(int i=0;i<array.length;i++){
            if(array[i][1].equals(person)){
                parents.add(array[i][0]);
            }
        }
        List<String> ancestors = new ArrayList<>();
        for(String parent:parents){
            ancestors.addAll(findAncestors(array,parent));
        }
        ancestors.addAll(parents);
        return ancestors;
    }


    public static void main(String[] args) {
        String[][] inheretance = new String[][]{
                /// parent, child
                {"Alice","Carol"},
                {"Armin","Carol"},
                {"Carol","Eren"},
                {"Carol","Dave"},
                {"Dave","Annie"},
                {"Eve","Annie"},
                {"Annie","Frank"},
        };

        ArrayList<String> ancestors = (ArrayList<String>) findAncestors(inheretance,"Dave");
        System.out.println(ancestors);
    }
}
