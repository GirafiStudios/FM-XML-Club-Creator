package com.girafi.clubcreator.helper;

public class UtilityHelper {
    private static final long LIMIT = 1000000000L;
    private static long last = 0;

    public static long getRandomID() {
        // 9 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }
}