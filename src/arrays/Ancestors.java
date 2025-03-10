package arrays;

import java.util.ArrayList;
import java.util.List;

public class Ancestors {


    public static List<String> findAncestors(String [][] array,String person){
        List<String> ancestors = new ArrayList<>();
        // todo your code here
        List<String> parents = new ArrayList<>();
        for(String[] row: array){
            if(row[1].equals(person)){
                parents.add(row[0]);
                ancestors.add(row[0]);
            }
        }

        for(String parent: parents){
            List <String> parentAncestor = findAncestors(array,parent);
            ancestors.addAll(parentAncestor);
        }
        return ancestors;
    }

    public static List<String> findDescendants(String [][] array, String person){
        List<String> descendants = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        for(String[] row: array){
            if(row[0].equals(person)){
                parents.add(row[1]);
                descendants.add(row[1]);
            }
        }

        for(String parent: parents){
            List <String> childrenDescendants = findDescendants(array,parent);
            descendants.addAll(childrenDescendants);
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
        ArrayList<String> ancestors = (ArrayList<String>) findAncestors(inheretance,"Dave");
        System.out.println(ancestors);
        ArrayList<String> descendants = (ArrayList<String>) findDescendants(inheretance,"Dave");
        System.out.println(descendants);/// [Alice, Armin, Carol]
    }
}
