package com.gilbert.modern.ExecuteAroundPattern;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderprocessor {
    String process(BufferedReader b) throws IOException;
}
