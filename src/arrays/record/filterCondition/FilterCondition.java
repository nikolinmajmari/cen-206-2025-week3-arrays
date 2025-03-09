package arrays.record.filterCondition;

public abstract class FilterCondition<T> {
    private int index;
    private T value;

    FilterCondition(int index,T value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }

    public abstract boolean check(Object[] row);
    public abstract boolean check(T cell);
}
