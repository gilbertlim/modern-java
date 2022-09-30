package com.gilbert.modern.Lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LambdaMain {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Lambda / Expressions =====");

        Goods com = new Computer();
        com.doSome();

        // anonymous class
        Goods com2 = new Computer() {
            public void doSome() {
                log.debug("do Operation2!");
            }
        };
        com2.doSome();

        // lambda
        Goods com3 = () -> log.debug("do Operation3!");
        com3.doSome();

        /*
         * 람다식 표현법
         * * */

        // (타입 매개변수, 타입 매개변수) -> {};
        CalculatorParamAll cal4 = (int num1, int num2) -> {
            return num1 + num2;
        };
        log.debug("cal4.cal(1, 2) = " + cal4.cal(1, 2));

        // (매개변수, 매개변수) -> {}; | 타입 생략 조건 : 타입이 모두 같을 때
        CalculatorParamAll cal5 = (num1, num2) -> {
            return num1 + num2;
        };
        log.debug("cal5.cal(1, 2) = " + cal5.cal(1, 2));

        // () -> {};
        CalculatorParamNull cal6 = () -> {
            log.debug("cal6.cal() = 매개변수가 없는 경우입니다.");
        };
        cal6.cal();

        // () -> ;
        CalculatorParamAll cal7 = (num1, num2) -> num1 + num2;
        log.debug("cal7.cal(1, 2) = " + cal7.cal(1, 2));

        // 매개변수 -> ;
        CalculatorParamOne cal8 = num1 -> log.debug("cal8.cal(num1) = " + num1);
        cal8.cal(1);
    }

}
