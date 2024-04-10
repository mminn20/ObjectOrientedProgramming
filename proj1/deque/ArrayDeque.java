package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int CAPACITY = 8;

    public ArrayDeque(){
        items = (T[]) new Object[CAPACITY];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    public ArrayDeque(T item){
        items[3] = item;
        nextFirst = 2;
        nextLast = 4;
        size = 1;
    }

    private void resize(){
        if (size == 0){
            T[] arr = (T[]) new Object[CAPACITY];
            return;
        }
        if (size == items.length){
            int capUp = items.length * 2;
            T[] temp = (T[]) new Object[capUp];
            copyArr(temp, items);
            items = (T[]) new Object[capUp];
            copyArr(items, temp);
        }
        if (size < items.length/4 && items.length > 8) {
            int capDown = items.length / 2;
            T[] temp = (T[]) new Object[capDown];
            copyArr(temp, items);
            items = (T[]) new Object[capDown];
            copyArr(items, temp);
        }

    }


    private void copyArr(T[] arr1, T[] arr2){
        for (int i=0; i < arr2.length; i++) {
            arr1[i] = arr2[i];
        }
    }


    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        nextFirst--;
        if (nextFirst == -1) {
            resize();
        }
    }

    @Override
    public void addLast(T item) {
//        if (nextLast == items.length) {
//            resize();
//        }
        resize();
        items[nextLast] = item;
        nextLast++;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) return;
        int pos = nextFirst;
        while (pos < nextLast) {
            System.out.println(items[pos]);
            pos++;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        nextFirst++;
        T item = items[nextFirst];
        size--;
        items[nextFirst] = null;
        clearNext();
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        nextLast--;
        T item = items[nextLast];
        size--;
        items[nextLast] = null;
        clearNext();
        return null;
    }

    private void clearNext(){
        if (size == 0) resize();
        else if (items.length/4 > size && size >= 4) {
            resize();
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) return null;
        int i = nextFirst + 1 + index;
        return items[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        private ArrayDequeIterator() {
            index = 0;
        }

        public boolean hasNext(){
            return index < size;
        }

        public T next(){
            T item = get(index);
            index++;
            return item;
        }
    }

    public boolean equals(Object o){
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size() != other.size()) return false;

        return true;
    }
}
