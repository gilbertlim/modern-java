package com.gilbert.modern.Stream.Practice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Trader {

    private final String name;
    private final String city;

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
