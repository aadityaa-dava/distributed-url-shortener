package com.aadityaa.urlshortener.util;

public class Base62Encoder {

    private static final String BASE62 =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long value) {

        StringBuilder shortCode = new StringBuilder();

        while (value > 0) {
            shortCode.append(BASE62.charAt((int) (value % 62)));
            value /= 62;
        }

        return shortCode.reverse().toString();
    }
}