package arrays;

import java.util.ArrayList;
import java.util.List;

public class Ancestors {


    public static List<String> findAncestors(String [][] array,String person){
        List<String> ancestors = new ArrayList<>();
        // todo your code here
        return ancestors;
    }

    public static List<String> findDescendants(String [][] array, String person){
        List<String> descendants = new ArrayList<>();
        // todo your code here
        return descendants;
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
        System.out.println(ancestors); /// [Alice, Armin, Carol]
    }
}
