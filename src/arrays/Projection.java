package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Projection {

    public static ArrayList<Object[]> select(Object[][] records,int[] indexes){
        ArrayList<Object[]> result = new ArrayList<>();
        for(int i=0;i<records.length;i++){
            Object[] record = new Object[indexes.length];
            for(int j=0;j<indexes.length;j++){
                record[j] = records[i][indexes[j]];
            }
            result.add(record);
        }
        return result;
    }

    public static void main(String[] args) {
        Object[][] students = new Object[][]{
                // id, email, cityid
                {1,"ab@gmail.com",1,3.4f},
                {2,"ac@gmail.com",1,2.4f},
                {3,"ad@gmail.com",1,1.1f},
                {4,"ae@gmail.com",2,4f},
                {5,"af@gmail.com",2,3.9f},
                {6,"ba@gmail.com",3,3f},
                {7,"ca@gmail.com",3,2f},
                {8,"da@gmail.com",3,1.1f},
                {9,"ea@gmail.com",4,2.9f},
        };

        ArrayList<Object[]> projected = select(students,new int[]{1,3});
        for (Object[] row : projected) {
            System.out.println(Arrays.toString(row));
        }
        /**
         [ab@gmail.com, 3.4]
         [ac@gmail.com, 2.4]
         [ad@gmail.com, 1.1]
         [ae@gmail.com, 4.0]
         [af@gmail.com, 3.9]
         [ba@gmail.com, 3.0]
         [ca@gmail.com, 2.0]
         [da@gmail.com, 1.1]
         [ea@gmail.com, 2.9]
         */
    }
}
