package arrays.record;

import arrays.record.filterCondition.FilterEquals;
import arrays.record.filterCondition.FilterGreaterThan;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Recordset students = new Recordset(
            new Object[][]{}
        );
        long startInsertTime = System.currentTimeMillis();
        // id, email, city, program, cgpa
        for (int i=0;i<2000000;i++){
            students.insert(new Object[]{
                    i,"student"+i+"@mail.com",1%20+1,i%40+1,Math.random()*4
            });
        }
        long endInsertTime = System.currentTimeMillis();

        Recordset cities = new Recordset(
            new Object[][]{}
        );
        for (int i=0;i<40;i++){
            cities.insert(new Object[]{
                    i,"City"+i+"@mail.com",1%20
            });
        }
        Recordset programs = new Recordset(
                new Object[][]{}
        );
        for (int i=0;i<40;i++){
            programs.insert(new Object[]{
                    i,"Program "+i
            });
        }



        Long startQueryTime = System.currentTimeMillis();
        Recordset data = students
                //.where( new FilterEquals(3,2))
                .where( new FilterGreaterThan(3,30))
                .join(cities, 3,0)
                .join(programs, 2,0)
                .select(new int[]{1,4,6,8});
        long endQueryTime = System.currentTimeMillis();
        System.out.printf("Insert duration %d\n  Query Duration %d\n", endInsertTime - startInsertTime, endQueryTime - startQueryTime);
        System.out.println("Queried "+data.getData().size()+" records");

    }
}
