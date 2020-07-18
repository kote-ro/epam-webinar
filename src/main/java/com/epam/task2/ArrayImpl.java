package com.epam.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] arr;

    public ArrayImpl(int n){
        arr = new Object[0];
    }

    @Override
    public void clear() {
        arr = new Object[0];
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int indx = -1;

        @Override
        public boolean hasNext() {
            if (indx < arr.length - 1) return true;
            return false;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if (indx > arr.length - 1) {
                throw new NoSuchElementException("No more elements in this array.");
            }
            indx++;
            return arr[indx];
        }
        @Override
        public void remove(){
            ArrayImpl.this.remove(indx);
        }
    }

    @Override
    public void add(Object element) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = element;
        arr = newArr;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index >=  arr.length) return;
        arr[index] = element;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >=  arr.length) return null;
        return arr[index];
    }

    @Override
    public int indexOf(Object element) {
        int indxOf = -1;
        for (int i = 0; i < arr.length; i++){
            if (element.equals(arr[i])) {
                indxOf = i;
                break;
            }
        }
        return indxOf;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >=  arr.length) return;
        Object[] newArr = new Object[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++){
            if (i != index) {
                newArr[j] = arr[i];
                j++;
            }
        }
        arr = newArr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++){
            res.append(arr[i]);
            if (i != arr.length - 1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayImpl objects = new ArrayImpl(5);
        objects.add(1);
        objects.add(2);
        objects.add(3);
    }

}
