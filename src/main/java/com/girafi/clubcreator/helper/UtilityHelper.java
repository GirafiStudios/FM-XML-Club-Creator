package com.girafi.clubcreator.helper;

public class UtilityHelper {
    private static final long LIMIT = 1000000000L;
    private static long last = 0;

    public static long getRandomID() {
        // 9 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getInhabitantsRage(String input) {
        switch (input) {
            case "0 - 1000":
                return 1;
            case "1001 - 2500":
                return 2;
            case "2501 - 5000":
                return 3;
            case "5001 - 10000":
                return 4;
            case "10001 - 25000":
                return 5;
            case "25001 - 50000":
                return 6;
            case "50001 - 100000":
                return 7;
            case "100001 - 250000":
                return 8;
            case "250001 - 500000":
                return 9;
            case "500001 - 1000000":
                return 10;
            case "1000001 - 2500000":
                return 11;
            case "2500001 - 5000000":
                return 12;
            case "5000001 - 10000000":
                return 13;
            case "10000001 - 20000000":
                return 14;
            case "20000000+":
            case "20000000 +":
                return 15;
            default:
                return 0;
        }
    }
}