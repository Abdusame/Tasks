package tasks.innerclasses;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итераторы. 9.
 * Измените пример innerclasses/Sequence.java таким образом,
 * чтобы контейнер Sequence работал с Iterator вместо Selector.
 * */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    public Iterator iterator() {
        return new SequenceIterator();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }

    private class SequenceIterator implements Iterator {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != items.length;
        }

        @Override
        public Object next() {
            try {
                int i = cursor;
                Object next = items[i];
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }
}
