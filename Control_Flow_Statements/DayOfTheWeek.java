public class DayOfTheWeekChallenge {


    public static void printOfTheWeek(int day) {
        int DayNumber = 9;
        if (DayNumber == 0)
            System.out.println("Sunday");
        else {
            if (DayNumber == 1)
                System.out.println("Monday");
            else {
                if (DayNumber == 2)
                    System.out.println("Tuesday");
                else {
                    if (DayNumber == 3)
                        System.out.println("Wednesday");
                    else {
                        if (DayNumber == 4)
                            System.out.println("Thursday");
                        else {
                            if (DayNumber == 5)
                                System.out.println("Friday");
                            else {
                                if (DayNumber == 6)
                                    System.out.println("Saturday");
                                else {
                                    System.out.println("Invalid Day");

                                }
                            }
                        }
                    }
                }
            }
        }


// Bonus challenge - if statement
        //        {
//            int DayNumber = 9;
//            switch (DayNumber) {
//                case 0:
//                    System.out.println("Sunday");
//                    break;
//                case 1:
//                    System.out.println("Monday");
//                    break;
//                case 2:
//                    System.out.println("Tuesday");
//                    break;
//                case 3:
//                    System.out.println("Wednesday");
//                    break;
//                case 4:
//                    System.out.println("Thursday");
//                    break;
//                case 5:
//                    System.out.println("Fri");
//                    break;
//                case 6:
//                    System.out.println("Saturday");
//                    break;
//                default:
//                    System.out.println("Invalid day");
//                    break;
//            }
//
//        }
    }
}
