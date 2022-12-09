package com.solvd.hospital.customlinkedlist;

import java.util.*;

public class TestList<T> implements List<T> {

    Node<T> head;

    private int length = 0;

    TestList() {
        this.head = null;
    }

    @Override//done
    public void clear() {
        head = null;
        length = 0;
    }

    @Override//done
    public int size() {
        return length;
    }

    @Override//done
    public boolean isEmpty() {
        return head == null;
    }

    @Override//done
    public boolean add(T data) {
        Node<T> temp = new Node<>(data);
        if (this.head == null) {
            head = temp;
        }
        else {
            Node<T> X = this.head;
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }
        length++;
        return true;
    }

    @Override //done
    public T get(int index) {
        Node<T> temp = head.next;
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Вышел за пределы");
        }
        if (index == 0)
            return head.data;
        else {
            for (int i = 1; i != index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    @Override//done
    public T set(int index, T element) {
        Node<T> temp = head.next;
        Node<T> previousVar = head;
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Вышел за пределы");
        }
        if (index == 0) {
            head.data = element;
            return previousVar.data;
        } else {
            for (int i = 1; i < length; i++) {
                previousVar.data = temp.data;
                if (i == index) {
                    temp.data = element;
                }
                temp = temp.next;
            }
        }
        return previousVar.data;
    }

    @Override//done
    public void add(int index, T element) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Элемент под идексом " + index + " нельзя добавить, так как в листе максимальное значение " + length);
        }

        if (index == 0) {
            Node<T> temp = head;
            head = new Node<>(element);
            head.next = temp;
            return;
        }

        Node<T> temp = head;
        Node<T> prev = new Node<>(null);
        while (index > 0) {
            prev = temp;
            temp = temp.next;
            index--;
        }
        prev.next = new Node<>(element);
        prev.next.next = temp;
    }

    @Override //done
    public boolean remove(Object o) {
        Node<T> prev = new Node<>(null);
        for (Node<T> x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                //если послед эл
                if (x.next == null) {
                    prev.next.next = null;
                    length--;
                    return true;
                }
                //если первый
                if (prev.data == null) {
                    head = x.next;
                    length--;
                }
                //если в середине
                prev.next = x.next;
            }
            prev = head;
        }
        return false;
    }

    @Override //done
    public int indexOf(Object o) {
        int index = 0;

        if (o == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (o.equals(x.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override //done
    public String toString() {
        String S = "{";
        Node<T> X = head;
        if (X == null) {
            return S + " }";
        }
        while (X.next != null) {
            S += X.data;
            X = X.next;
        }
        S += X.data;
        return S + " }";
    }

    /////////////////////////////////////////////
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
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
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    class Node<T> {
        //значение текущей ноды
        T data;
        //ссылка на след эл
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
