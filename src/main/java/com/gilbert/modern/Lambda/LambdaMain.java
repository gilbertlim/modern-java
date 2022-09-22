package com.gilbert.modern.Lambda;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LambdaMain {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        Goods com = new Computer();
        com.doSome();


        // anonymous class
        Goods com2 = new Computer() {
            public void doSome() {
                System.out.println("do Operation2!");
            }
        };
        com2.doSome();

        // lambda
        Goods com3 = () -> System.out.println("do Operation3!");
        com3.doSome();

        /*
        * 람다식 표현법
        * * */


        // (타입 매개변수, 타입 매개변수) -> {};
        CalculatorParamAll cal4 = (int num1, int num2) -> { return num1 + num2; };
        System.out.println("cal4.cal(1, 2) = " + cal4.cal(1, 2));

        // (매개변수, 매개변수) -> {}; | 타입 생략 조건 : 타입이 모두 같을 때
        CalculatorParamAll cal5 = (num1, num2) -> { return num1 + num2; };
        System.out.println("cal5.cal(1, 2) = " + cal5.cal(1, 2));

        // () -> {};
        CalculatorParamNull cal6 = () -> { System.out.println("cal6.cal() = 매개변수가 없는 경우입니다."); };
        cal6.cal();

        // () -> ;
        CalculatorParamAll cal7 = (num1, num2) -> num1 + num2;
        System.out.println("cal7.cal(1, 2) = " + cal7.cal(1, 2));

        // 매개변수 -> ;
        CalculatorParamOne cal8 = num1 -> System.out.println("cal8.cal(num1) = " + num1);
        cal8.cal(1);
    }

}
