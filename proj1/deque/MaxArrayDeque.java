package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c){
        comparator = c;
    }

    public T max(){
        return max(comparator);
    }

    public T max(Comparator<T> c){
        if (isEmpty()) return null;
        int index = 0;
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(i), get(index)) > 0) {
                index = i;
            }
        }
        return get(index);
    }
}
