package com.solvd.hospital.customlinkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestList<T> implements List<T> {

    //первая нода в нашем листе
    Node<T> head;

    private int length = 0;

    // объявление листа
    TestList() {
        this.head = null;
    }

    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(T data) {
        //создание новой ноды с нашими данными
        Node<T> temp = new Node<>(data);
        //если в листе нету первой ноды, то присваиваем текущее значение
        if (this.head == null) {
            head = temp;
        }
        //если есть в листе нода
        else {
            //временная нода, которая указывает на начальную позицию
            Node<T> X = this.head;
            //цикл, проверяем есть ли сосед у текущей ноды
            while (X.next != null) {
                //меняем начальную позицию на соседа
                X = X.next;
            }
            //добавление соседа к последней ноде в листе
            X.next = temp;
        }
        length++;
        return true;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index > length + 1) {
            throw new IndexOutOfBoundsException("Элемент под идексом + " + index + " нельзя добавить, так как в листе максимальное значение " + length + 1);
        }

        if (index == 1) {
            Node<T> temp = head;
            head = new Node<>(element);
            head.next = temp;
            return;
        }

        Node<T> temp = head;
        Node<T> prev = new Node<>(null);
        while (index - 1 > 0) {
            prev = temp;
            temp = temp.next;
            index--;
        }
        prev.next = new Node<>(element);
        prev.next.next = temp;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
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

    @Override
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

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
