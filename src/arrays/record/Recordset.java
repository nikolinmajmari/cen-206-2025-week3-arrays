package arrays.record;

import arrays.Joins;
import arrays.record.filterCondition.FilterCondition;

import java.util.*;


public class Recordset implements Iterable<Object[]> {
    private ArrayList<Object[]> data;
    public Recordset() {
        data = new ArrayList<>();
    }
    public Recordset(Object[][] objects) {
        this.data = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            this.data.add( objects[i]);
        }
    }
    public Recordset(ArrayList<Object[]> objects) {
        this.data = objects;
    }
    public ArrayList<Object[]> getData() {
        return data;
    }

    /**
     *
     * @param condition
     * @return
     */
    public Recordset where(FilterCondition condition) {
        Object[][] filtered = this.data.stream().filter((Object[] o)->{
            if(!condition.check(o)){
                return false;
            }
            return true;
        }).toArray(Object[][]::new);
        return new Recordset(filtered);
    }

    /**
     *
     * @param indexes
     * @return
     */
    public Recordset select(int[] indexes){
        Object[][] newRecords = new Object[this.data.size()][];
        for (int i=0;i<this.data.size();i++){
            Object[] newObject = new Object[indexes.length];
            Object[] o = this.data.get(i);
            for (int j = 0; j < indexes.length; j++) {
                newObject[j] = o[indexes[j]];
            }
            newRecords[i] = newObject;
        }
        return new Recordset(newRecords);
    }

    /**
     *
     * @param rightSet
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public Recordset join(Recordset rightSet, int leftIndex, int rightIndex){
        ArrayList<Object[]> objects = new ArrayList<>();
        for (Object[] left : this) {
            for(Object[] right : rightSet){
                if(left[leftIndex].equals(right[rightIndex])){
                    objects.add(Joins.mergeArrays(left, right));
                }
            }
        }
        return new Recordset(objects.toArray(Object[][]::new));
    }

    public void insert(Object[] data){
        this.data.add(data);
    }

    @Override
    public Iterator<Object[]> iterator() {
        return new RecordIterator(this);
    }
}

class RecordIterator implements Iterator<Object[]> {
    Recordset rs;
    int index = 0;
    RecordIterator(Recordset rs){
        this.rs = rs;
    }

    @Override
    public boolean hasNext() {
        return this.index < rs.getData().size();
    }

    @Override
    public Object[] next() {
        return this.rs.getData().get(index++);
    }
}

