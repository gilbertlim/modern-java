package com.gilbert.modern.AbstractClass;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Animal {

    @Setter
    String name;

    void printName() {
        log.debug("name");
    }
}
