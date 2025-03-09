package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Filtering {

    public static ArrayList<Object[]> where(Object[][]records, Map<Integer,Integer> conditions) {
        ArrayList<Object[]> filtered = new ArrayList<>();
        // todo your code here
        return filtered;
    }

    public static void main(String[] args) {
        Object[][] students = new Object[][]{
                // id, email, cityid,programid,cgpa
                {1,"ab@gmail.com",1,1,3.4f},
                {2,"ac@gmail.com",1,2,2.4f},
                {3,"ad@gmail.com",1,2,1.1f},
                {4,"ae@gmail.com",2,1,4f},
                {5,"af@gmail.com",2,1,3.9f},
                {6,"ba@gmail.com",3,2,3f},
                {7,"ca@gmail.com",3,1,2f},
                {8,"da@gmail.com",3,2,1.1f},
                {9,"ea@gmail.com",4,1,2.9f},
        };


        ArrayList<Object[]> filtered = where(students,Map.of(
                2,1,3,2
        ));
        for (Object[] row : filtered) {
            System.out.println(Arrays.toString(row));
        }
        /**
         [2, ac@gmail.com, 1, 2, 2.4]
         [3, ad@gmail.com, 1, 2, 1.1]
         */
    }
}
