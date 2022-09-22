package com.gilbert.modern.Generic;

public class GenericClass<T> {
    private T val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public GenericClass(T val) {
        this.val = val;
    }
}
