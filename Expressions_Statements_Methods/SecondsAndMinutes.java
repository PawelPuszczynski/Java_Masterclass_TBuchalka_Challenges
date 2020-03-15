package com.company;

public class Main {
    private static  final String INVALID_VALUE_MESSAGE = "Invalid value";
    public static void main(String[] args) {


        System.out.println(getDurationString(191L, 0L));
        System.out.println(getDurationString(3945L));
        System.out.println((getDurationString(-41)));
        System.out.println(getDurationString(65,9));
    }


    private static String getDurationString(long minutes, long seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        } else {
            long hours = (int) minutes / 60;
            long remainingMinutes = (int) minutes % 60;

            String hoursString = hours +"h";
            if (hours < 10) {
                hoursString ="0" + hoursString;
            }
            String minutesString = remainingMinutes +"h";
            if (remainingMinutes < 10) {
                minutesString ="0" + minutesString;
            }

            String secondsString = seconds +"h";
            if (seconds < 10) {
                secondsString ="0" + secondsString;
            }


                return (hoursString + " hours " + minutesString + " minutes " + secondsString + " seconds");

        }
    }

    private static String getDurationString(long seconds) {
        if (seconds < 0) {

            return INVALID_VALUE_MESSAGE;

        }
        else {
            long minutes = (int) seconds / 60;
            long remainingSeconds = (int) seconds % 60;

            return getDurationString(minutes, remainingSeconds);

        }
    }
}
