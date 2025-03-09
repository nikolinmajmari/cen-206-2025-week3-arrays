package arrays.record.filterCondition;

public class FilterEquals extends FilterCondition<Object>{
    public FilterEquals(int index, Object value) {
        super(index,value);
    }

    @Override
    public boolean check(Object[] row) {
        return row[getIndex()].equals(getValue());
    }

    @Override
    public boolean check(Object cell) {
        return cell.equals(getValue());
    }
}
