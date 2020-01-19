package ru.otus.hw03;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class DIYArrayList<T> implements List<T> {

    public Object[] array;
    final int DEFAULT_CAPACITY = 10;
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

    @Override
    public T set(int index, T element) {
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

    @Override
    public T get(int i) {
        return (T)array[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor;
            @Override
            public boolean hasNext() {
                return cursor < size();
            }
            @Override
            public T next() {
                return (T)array[cursor++];
            }
        };
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }


    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


}
