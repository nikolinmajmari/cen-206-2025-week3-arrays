package arrays.record.depricated;

import arrays.Joins;
import arrays.record.Recordset;
import arrays.record.filterCondition.FilterCondition;
import arrays.record.filterCondition.FilterEquals;
import arrays.record.filterCondition.FilterGreaterThan;

import java.util.*;

public class IndexedRecordset extends Recordset {
    private HashMap<Object, Map<Object, ArrayList<Object[]>>> indexSet = new HashMap<>();

    IndexedRecordset() {
        super();
    }

    public IndexedRecordset(Object[][] objects) {
        super(objects);
    }
    public IndexedRecordset(ArrayList<Object[]> objects) {
        super(objects);
    }

    public IndexedRecordset(Recordset set){
        super(set.getData());
    }

    private void createIndex(int index){
        Map<Object, ArrayList<Object[]>> indexMap = new HashMap<>();
        for (Object[] row :this){
            if(!indexMap.containsKey(row[index])){
                indexMap.put(row[index], new ArrayList<>());
            }
            indexMap.get(row[index]).add(row);
        }
        indexSet.put(index, indexMap);
    }

    public IndexedRecordset join(IndexedRecordset rightSet, int leftIndex, int rightIndex) {
        Map<Object,ArrayList<Object[]>> leftMap = indexSet.get(leftIndex);
        Map<Object,ArrayList<Object[]>> rightMap = rightSet.indexSet.get(rightIndex);
        ArrayList<Object[]> results = new ArrayList<>();
        if(leftMap!=null && rightMap!=null){
            for (Map.Entry<Object, ArrayList<Object[]>> entry : leftMap.entrySet()) {
                if(rightMap.containsKey(entry.getKey())){
                    for(Object[] leftRow : entry.getValue()){
                        for (Object[] rightRow : rightMap.get(entry.getKey()) ){
                            results.add(Joins.mergeArrays(leftRow, rightRow));
                        }
                    }
                }
            }
            return new IndexedRecordset(results);
        } else if (leftMap!=null) {
            for(Object[] rightRow : rightSet){
                if(leftMap.containsKey(rightRow[rightIndex])){
                    for(Object[] leftRow : leftMap.get(rightRow[rightIndex])){
                        results.add(Joins.mergeArrays(leftRow, rightRow));
                    }
                }
            }
            return new IndexedRecordset(results);
        } else if (rightMap!=null) {
            for(Object[] leftRow : this){
                if (rightMap.containsKey(leftRow[leftIndex])){
                    for (Object[] rightRow : rightMap.get(leftRow[leftIndex])){
                        results.add(Joins.mergeArrays(leftRow, rightRow));
                    }
                }
            }
            return new IndexedRecordset(results);
        }
        return new IndexedRecordset(super.join(rightSet, leftIndex, rightIndex));
    }

    public IndexedRecordset where(FilterCondition condition) {
        if (condition instanceof FilterEquals &&
                this.indexSet.containsKey(condition.getIndex())){
            ArrayList<Object[]> results =
                    this.indexSet.get(condition.getIndex()).get(condition.getValue());
            return new IndexedRecordset(results);
        }else if(this.indexSet.containsKey(condition.getIndex())){
            ArrayList<Object[]> results = new ArrayList<>();
            for (Map.Entry<Object,ArrayList<Object[]>> entry :this.indexSet.get(condition.getIndex()).entrySet()){
                if(condition.check(entry.getKey())){
                    results.addAll(entry.getValue());
                }
            }
            return new IndexedRecordset(results);
        }
        return new IndexedRecordset(super.where(condition));
    }

    public IndexedRecordset select(int[] array) {
        return new IndexedRecordset(super.select(array));
    }

    public void insert(Object[] data) {
        super.insert(data);
    }

    public static void main(String[] args){
        IndexedRecordset students = new IndexedRecordset();
        long startInsertTime = System.currentTimeMillis();
        // id, email, city, program, cgpa
        for (int i=0;i<2000000;i++){
            students.insert(new Object[]{
                    i,"student"+i+"@mail.com",1%20+1,i%40+1,Math.random()*4
            });
        }
        long endInsertTime = System.currentTimeMillis();

        IndexedRecordset cities = new IndexedRecordset();
        for (int i=0;i<40;i++){
            cities.insert(new Object[]{
                    i,"City"+i+"@mail.com",1%20
            });
        }
        IndexedRecordset programs = new IndexedRecordset();
        for (int i=0;i<40;i++){
            programs.insert(new Object[]{
                    i,"Program "+i
            });
        }

        students.createIndex(3);
        students.createIndex(2);
        programs.createIndex(0);
        cities.createIndex(0);
        Long startQueryTime = System.currentTimeMillis();
        IndexedRecordset data = students
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
