package com.epam.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    private Object[] arr;

    public StackImpl() {
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

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int t;

        public IteratorImpl(){
            t = StackImpl.this.arr.length;
        }

        @Override
        public boolean hasNext() {
            return t > 0;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if (t == 0) {
                throw new NoSuchElementException();
            }
            t--;
            return arr[t];
        }

        @Override
        public void remove() {
            if (t < 0 || t >= arr.length) return;
            Object[] newArr = new Object[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (i != t) {
                    newArr[j] = arr[i];
                    j++;
                }
            }
            arr = newArr;
        }

    }

    private Object[] copy(int n){
        Object[] arrNew = new Object[n];
        int m = Math.min(arr.length, arrNew.length);
        for (int i = 0; i < m; i++) {
            arrNew[i] = arr[i];
        }
        return arrNew;
    }

    @Override
    public void push(Object element) {
        Object[] arrNew = copy(arr.length + 1);
        arrNew[arr.length] = element;
        arr = arrNew;
    }

    @Override
    public Object pop() {
        if (arr.length == 0) return null;
        Object p = arr[arr.length - 1];
        Object[] arrNew = copy(arr.length - 1);
        arr = arrNew;
        return p;
    }

    @Override
    public Object top() {
        return arr.length == 0 ? null : arr[arr.length - 1];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i != arr.length - 1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
    }

}
