package com.gilbert.modern.BehaviorParameterization;

public interface ApplePredicate {
    // predicate : true or false를 반환하는 함수
    // java.util.function.Predicate<T> 인터페이스를 사용해도 됨.

    boolean test(Apple apple);
}
