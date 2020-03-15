public class MinutesToYearsAndDaysCalculator {

    public static void printYearsAndDays(long minutes) {

        if (minutes < 0)
            System.out.println("Invalid Value");

        else {
            int years = (int) minutes / (60 * 24 * 365);
            int remainingMinutes = (int) minutes % (60 * 24 * 365);
            int days = (int) remainingMinutes / (60 * 24);

            String yearsString = years + " y";
//            if (years < 10)
//                yearsString = "0" + years + " y";

            String daysString = days + " d";
//            if (days < 10)
//                daysString = "0" + days + " d";
            String minutesString = minutes + " min";
//            if (minutes < 10)
//                minutesString = "0" + minutes + " min";

            System.out.println(minutesString + " = " + yearsString + " and " + daysString);

        }
    }
}
