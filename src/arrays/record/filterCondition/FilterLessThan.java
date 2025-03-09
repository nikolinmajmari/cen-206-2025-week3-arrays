package arrays.record.filterCondition;

public class FilterLessThan<T extends Comparable<T>> extends FilterCondition<T> {
    FilterLessThan(int index, T value) {
        super(index, value);
    }

    @Override
    public boolean check(Object[] row) {
        return getValue().compareTo((T)row[getIndex()])>0;
    }

    @Override
    public boolean check(T cell) {
        return getValue().compareTo(cell)>0;
    }
}
