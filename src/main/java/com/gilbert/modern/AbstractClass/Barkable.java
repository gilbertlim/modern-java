package com.gilbert.modern.AbstractClass;

public interface Barkable {

    void bark();

    // 인터페이스의 메서드는 몸통을 가질 수 없지만 디폴트 메서드를 사용하면 구현된 형태의 메서드를 가질 수 있음.
    default void dm() {
        System.out.println();
    }
}
