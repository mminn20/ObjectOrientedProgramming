package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private NodeSet sentinel;
    private NodeSet first;
    private NodeSet last;
    public T item;

    private class NodeSet {
        T data;
        public NodeSet next;
        public NodeSet prev;

        public NodeSet() {
            next = null;
            prev = null;
        }

        public NodeSet(T item) {
            data = item;
            next = null;
            prev = null;
        }
    }

    public LinkedListDeque() {
        size = 0;
        this.first = null;
        this.last = null;
    }

    public void addFirst(T item) {
        NodeSet newNode = new NodeSet(item);
//        newNode.data = item;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        }
        first = newNode;
        size++;
        if (first.next == null) {
            last = first;
        }
    }

    public void addLast(T item) {
        NodeSet newNode = new NodeSet(item);
//        newNode.data = item;
        if (size == 0) {
            addFirst(item);
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        NodeSet firstNode = first;
        if (firstNode == null || size == 0) {
            return null;
        }
        T removeVal = firstNode.data;
        NodeSet nextNode = first.next;
        first.data = null;
        first.next = null;
        first.prev = null;
        if (nextNode != null) {
            nextNode.prev = null;
        }
        first = nextNode;
        size--;
        if (size == 0) last = null;
        return removeVal;
    }

    public T removeLast() {
        NodeSet lastNode = last;
//        if (lastNode == null) {
//            return null;
//        }
        if (isEmpty()) return null;

        T removeVal = lastNode.data;
        NodeSet prevNode = last.prev;
        last.data = null;
        last.next = null;
        last.prev = null;
        if (lastNode != null) {
            lastNode.next = null;
        }
        last = prevNode;
        size--;
        if (size == 0) first = null;
        return removeVal;
    }

    public T get(int index) {
        if (index < 0) return null;
        int count = 0;
        if (first.next != null) {
            NodeSet pointer = first;
            while (pointer != null) {
                if (count == index) {
                    return pointer.data;
                }
                pointer = pointer.next;
                count++;
            }
        }
        return null;
    }


    public T getRecursive(int index) {
        if (index < 0 || index > size) return null;
        NodeSet pointer = first;
        int count = 0;
        return getRecursiveHelper(index, count, pointer);
    }

    public T getRecursiveHelper(int index, int count, NodeSet pointer) {
        if (index == count) {
            return pointer.data;
        }
        if (pointer.data == null) {
            return null;
        }
        return getRecursiveHelper(index, count+1, pointer.next);
    }

        public void printDeque () {
        if (first == null) {
            return;
        }
            NodeSet pointer = first.next;
            System.out.println(first.data);
            while (pointer != null) {
                int i = 0;
                System.out.println(pointer.data);
                pointer = pointer.next;
                i++;
            }
            System.out.println();
        }

        public Iterator<T> iterator() {
            return new LinkedListIterator();
        }

        private class LinkedListIterator implements Iterator<T> {
            private int pos;

            private LinkedListIterator() {
                pos = 0;
            }

            public boolean hasNext() {
                return pos < size;
            }

            public T next() {
                T item = get(pos);
                pos += 1;
                return item;
            }
        }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size() != size) return false;
        for (int i=0; i < size; i++){
            if (other.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        if (item == null) {
            return "null";
        }
        return item.toString();
    }
}





