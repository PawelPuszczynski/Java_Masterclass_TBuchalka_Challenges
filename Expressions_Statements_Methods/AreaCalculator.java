public class AreaCalculator {


    private static final double PI_VALUE = Math.PI ;

    public static double area(double radius)
    {
        if (radius<0)
            return -1;
        else {

            double areaOfCircle = radius * radius * PI_VALUE ;
            return areaOfCircle;
        }
    }

    public static double area(double x, double y)
    {
        if (x<0 || y <0)
            return -1;
        else {
            double areaOfRectangle = x*y;
            return areaOfRectangle;
        }
    }
}
