package com.gilbert.modern.Stream.Practice;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;


    public static List<Transaction> transactions() {
        Trader trader1 = new Trader("Raoul", "Cambridge");
        Trader trader2 = new Trader("Mario", "Milan");
        Trader trader3 = new Trader("Alan", "Cambridge");
        Trader trader4 = new Trader("Brian", "Cambridge");

        return Arrays.asList(
            new Transaction(trader4, 2011, 300),
            new Transaction(trader1, 2012, 1000),
            new Transaction(trader1, 2011, 400),
            new Transaction(trader2, 2012, 710),
            new Transaction(trader2, 2012, 700),
            new Transaction(trader3, 2012, 950)
        );
    }
}
