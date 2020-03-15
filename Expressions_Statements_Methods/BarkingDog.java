public class BarkingDog {

    public static boolean shouldWakeUp(boolean isDogBarking, int hourOfDay) {

        if (!(hourOfDay < 0 || hourOfDay > 23) && (isDogBarking && (hourOfDay < 8) || (hourOfDay > 22)))
        {
        return true;
        } else return false ;


    }
}
