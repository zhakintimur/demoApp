package com.example.demoapp.util;

public class AccountIdSequence {
    private static Long accountCounter = 0L;
    public static Long next() {
        return ++accountCounter;
    }
}
