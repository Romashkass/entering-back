package com.example.entering_back;

import java.util.Arrays;

public class Algorithm {

    public String middleElement(String str) {
        String[] parts = str.split(" ");
        if (parts.length != 3) {
            return null;
        }
        return Arrays.stream(parts).map(Integer::parseInt).sorted().toArray()[1].toString();
    }
}
