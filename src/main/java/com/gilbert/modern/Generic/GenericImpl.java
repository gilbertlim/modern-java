package com.gilbert.modern.Generic;

public class GenericImpl<T> implements GenericInterface<T> {

    private T[] array;

    public GenericImpl() {
        array = (T[]) new Object[10];
    }

    @Override
    public void addElement(T element, int index) {
        array[index] = element;
    }

    @Override
    public T getElement(int index) {
        return array[index];
    }
}
