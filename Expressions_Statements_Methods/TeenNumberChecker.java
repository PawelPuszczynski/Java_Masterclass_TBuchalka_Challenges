public class TeenNumberChecker {

    public static boolean hasTeen (int FirstPar, int SecondPar, int ThirdPar ) {
        if (isTeen(FirstPar) || isTeen(SecondPar) || isTeen(ThirdPar))
        {return true ;}
        else return false;
    }

    public static boolean isTeen (int Parameter ) {
        if (Parameter>=13 && Parameter <=19)
        {return true ;}
        else return false;
    }
}
