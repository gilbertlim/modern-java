package com.gilbert.modern.Lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Computer implements Goods {

    @Override
    public void doSome() {
        log.debug("do Operation!");
    }
}
