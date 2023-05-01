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
        return switch (input) {
            case "0 - 1000" -> 1;
            case "1001 - 2500" -> 2;
            case "2501 - 5000" -> 3;
            case "5001 - 10000" -> 4;
            case "10001 - 25000" -> 5;
            case "25001 - 50000" -> 6;
            case "50001 - 100000" -> 7;
            case "100001 - 250000" -> 8;
            case "250001 - 500000" -> 9;
            case "500001 - 1000000" -> 10;
            case "1000001 - 2500000" -> 11;
            case "2500001 - 5000000" -> 12;
            case "5000001 - 10000000" -> 13;
            case "10000001 - 20000000" -> 14;
            case "20000000+", "20000000 +" -> 15;
            default -> 0;
        };
    }

    public static int getPitchType(String input) {
        return switch (input) {
            case "Grass" -> 1;
            case "Synthetic (New Type - Soft)" -> 2;
            case "Synthetic (Old Type - Hard)" -> 3;
            case "Gravel/Clay/Sand" -> 4;
            case "Gravel" -> 5;
            case "Clay" -> 6;
            case "Sand" -> 7;
            case "Grass/Synthetic Mix" -> 8;
            default -> 0;
        };
    }

    public static int getPitchDeterioration(String input) {
        return switch (input) {
            case "Slow" -> 1;
            case "Medium" -> 2;
            case "Fast" -> 3;
            default -> 2;
        };
    }

    public static int getStadiumCondition(String input) {
        return switch (input) {
            case "Very Good" -> 1;
            case "Good" -> 2;
            case "Poor" -> 3;
            case "Very Poor" -> 4;
            default -> 0;
        };
    }

    public static int getStadiumEnvironment(String input) {
        return switch (input) {
            case "Basic" -> 1;
            case "Standard" -> 2;
            case "High End" -> 3;
            case "State Of The Art" -> 4;
            default -> 0;
        };
    }
}