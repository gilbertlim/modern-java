package com.gilbert.modern.AbstractClass;

public abstract class Predator extends Animal implements Barkable {

    // 인터페이스의 메소드와 같은 역할을 하는 메소드는 abstract를 붙여야 함.
    // 상속받는 클래스에서 해당 abstract 메소드를 구현해야 함.
    abstract String getFood();

    void printFood() {
        System.out.println();
    }

    // 추상 클래스에서 상수는 static을 붙여야 함.
    static int LEG_COUNT = 4;

    static int speed() {
        return LEG_COUNT * 30;
    }

}
