package com.gilbert.modern.Generic;


import java.util.Arrays;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericUse {

    @EventListener(ApplicationStartedEvent.class)
    public void use() {
        log.info("===== Generic =====");

        // class
        GenericClass<String> stringObj = new GenericClass<>("abc");
        log.debug("stringMadPlay.getVal() = " + stringObj.getVal());
        GenericClass<Integer> integerObj = new GenericClass<>(1);
        log.debug("stringMadPlay.getVal() = " + integerObj.getVal());

        // interface
        GenericImpl<String> genericImpl = new GenericImpl<>();
        genericImpl.addElement("abc", 0);
        log.debug("genericImpl.getElement(0) = " + genericImpl.getElement(0));
        ;

        // method
        String[] array = new String[]{"a", "b", "c"};
        Stack<String> stack = new Stack<>();
        arrayToStack(array, stack);
        log.debug("stack.get(0) = " + stack.get(0));
    }

    // method
    public static <T> void arrayToStack(T[] arr, Stack<T> stack) {
        stack.addAll(Arrays.asList(arr));
    }

}
