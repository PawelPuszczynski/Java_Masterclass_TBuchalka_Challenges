public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces (double FirstNumber, double SecondNumber)
    {
        double MultipliedFirstNumber = FirstNumber *1000 ;
         double MultipliedSecondNumber = SecondNumber *1000 ;
        if ((int) MultipliedFirstNumber == (int) MultipliedSecondNumber) {
            return true;
        } else {
            return false ;
        }

    }
}
