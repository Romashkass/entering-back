package com.example.entering_back.util;

import com.example.entering_back.exception.WrongNumberOfArgumentsException;

import java.util.Arrays;

public class Algorithm {

    public String middleElement(String str) {
        String[] parts = str.split(" ");
        if (parts.length != 3) {
            throw new WrongNumberOfArgumentsException("Should be exactly 3 arguments");
        }
        return Arrays.stream(parts).map(Integer::parseInt).sorted().toArray()[1].toString();
    }
}
