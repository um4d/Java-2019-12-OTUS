package ru.otus.hw02;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class DIYArrayList<T> implements List<T> {

    private Object[] array;
    private final int DEFAULT_CAPACITY = 10;
    private int size;

    public DIYArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T t) {
        if (size == array.length) {
            array = Arrays.copyOf(array, getNewCapacity());
        }
        array[size] = t;
        size ++;
        return true;
    }

    private int getNewCapacity() {
        return size * 2;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T set(int index, T element) {
        if (index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldElement = (T) array[index];
        array[index] = element;
        return oldElement;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T t : c) {
            add(t);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T)array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DIYArrayList<?> that = (DIYArrayList<?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    private class InnerIterator implements Iterator<T> {
        int lastReturned = -1;
        int cursor;
        @Override
        public boolean hasNext() {
            return cursor < size();
        }
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (cursor >= size()) throw new NoSuchElementException();
            lastReturned = cursor;
            return (T)array[cursor++];
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new InnerListIterator();
    }

    private class InnerListIterator extends InnerIterator implements ListIterator<T> {

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T previous() {
            if (cursor == 0) throw new NoSuchElementException();
            lastReturned = cursor;
            return (T) array[--cursor];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            DIYArrayList.this.set(lastReturned, t);
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }


    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> stream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < size(); i++){
            result.append(array[i].toString()).append(", ");
        }
        if (size() > 0) result.delete(result.length() - 2, result.length());
        return String.format("[%s]", result);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }


    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++ ) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        for(int i = 0; i < size(); i++ ) {
            if (array[i] == null) continue;
            if (array[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


}
