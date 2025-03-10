package arrays;

import java.util.ArrayList;
import java.util.List;

public class Ancestors {


    public static List<String> findAncestors(String [][] array,String person){
        List<String> ancestors = new ArrayList<>();
        // todo your code here
        List<String> parents = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i][1].equals(person)){
                parents.add(array[i][0]);
                ancestors.add(array[i][0]);
            }
        }
        //if(parents.size()==0){
            //return new ArrayList<>();
        //}
        for(String parent:parents){
            ancestors.addAll(findAncestors(array,parent));
        }
        return ancestors;
    }

    public static List<String> findDescendants(String [][] array, String person){
        List<String> descendants = new ArrayList<>();
        // todo your code here
        List<String> children = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i][0].equals(person)){
                children.add(array[i][1]);
                descendants.add(array[i][1]);
            }
        }
        //if(parents.size()==0){
        //return new ArrayList<>();
        //}
        for(String child:children){
            descendants.addAll(findDescendants(array,child));
        }
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
        ArrayList<String> ancestors = (ArrayList<String>) findDescendants(inheretance,"Dave");
        System.out.println(ancestors); /// [Alice, Armin, Carol]
    }
}
