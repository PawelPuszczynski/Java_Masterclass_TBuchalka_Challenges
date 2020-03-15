public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int nameTemperature)
    {
        if((summer && nameTemperature >= 25 && nameTemperature <=45)||(nameTemperature >= 25 && nameTemperature <=35))
        return true;
        else return false ;

        }
    }

