package com.epam.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    private Object[] arr;

    public QueueImpl() {
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

        int indx = -1;

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
            if (indx < 0 || indx >=  arr.length) return;
            Object[] newArr = new Object[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length; i++){
                if (i != indx) {
                    newArr[j] = arr[i];
                    j++;
                }
            }
            arr = newArr;
        }
    }

    @Override
    public void enqueue(Object element) {
        Object[] newArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = element;
        arr = newArr;
    }

    @Override
    public Object dequeue() {
        if (arr.length == 0) return null;
        Object p = arr[0];
        Object[] newArr = new Object[arr.length - 1];
        for (int i = 0; i < newArr.length; i++){
            newArr[i] = arr[i + 1];
        }
        arr = newArr;
        return p;
    }

    @Override
    public Object top() {
        if (arr.length == 0) return null;
        return arr[0];
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
        QueueImpl q = new QueueImpl();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

    }

}
