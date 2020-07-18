package com.epam.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node node;

    public ListImpl() {
        node = null;
    }

    @Override
    public void clear() {
        node = null;
    }

    @Override
    public int size() {
        int s = 0;
        Node temp = node;
        while (temp != null) {
            s++;
            temp = temp.next;
        }
        return s;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node it;

        public IteratorImpl() {
            it  = new Node(null, ListImpl.this.node);
        }

        @Override
        public boolean hasNext() {
            return it.next != null;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if (it == null) throw new NoSuchElementException("No more elements in this array.");
            it = it.next;
            return it.x;
        }

        public void remove() {}

    }

    private static class Node {
        Object x;
        Node next;

        Node(Object element) {
            x = element;
            next = null;
        }

        Node(Object element, Node nextNode) {
            x = element;
            next = nextNode;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node first = new Node(element, node);
        node = first;
    }

    @Override
    public void addLast(Object element) {
        if (node == null) {
            node = new Node(element);
        } else {
            Node temp = node;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(element);
        }
    }

    @Override
    public void removeFirst() {
        if (node != null && node.next != null) node = node.next;
        else node = null;
    }

    @Override
    public void removeLast() {
        if (node == null) return;
        if (node.next == null) {
            node = null;
            return;
        }
        Node temp = node;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    @Override
    public Object getFirst() {
        if (node == null) return null;
        return node.x;
    }

    @Override
    public Object getLast() {
        if (node == null) return null;
        Node temp = node;
        while (temp.next != null) temp = temp.next;
        return temp.x;
    }

    @Override
    public Object search(Object element) {
        if (element == null) {
            for (Node temp = node; temp != null; temp = temp.next) {
                if (temp.x == null)
                    return temp.x;
            }
        } else {
            for (Node temp = node; temp != null; temp = temp.next) {
                if (element.equals(temp.x))
                    return temp.x;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (node == null) return false;
        if (element == null) {
            if (node.x == element) {
                node = node.next;
                return true;
            }
            Node temp = node;
            while (temp.next != null && temp.next.x != element) temp = temp.next;
            if (temp.next == null) return false;
            temp.next = temp.next.next;
            return true;
        } else {
            if (element.equals(node.x)) {
                node = node.next;
                return true;
            }
            Node temp = node;
            while (temp.next != null && !element.equals(temp.next.x)) temp = temp.next;
            if (temp.next == null) return false;
            temp.next = temp.next.next;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        Node temp = node;
        while (temp != null) {
            res.append(temp.x);
            if (temp.next != null) res.append(", ");
            temp = temp.next;
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast(null);
    }
}
