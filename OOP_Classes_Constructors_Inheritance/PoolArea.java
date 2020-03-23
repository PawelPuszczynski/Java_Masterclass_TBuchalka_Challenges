public class Rectangle {
// FIELDS
    private double width;
    private double length;

    // CONSTRUCTORS
    public Rectangle(double width, double length) {
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if (length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
    }
        // METHODS
        public double getWidth() {
            return this.width;
        }

        public double getLength() {
            return this.length;
        }

        public double getArea (){
            return width*length;
        }
}
public class Cuboid extends Rectangle{
// FIELDS
    private double height;
// CONSTRUCTORS
    public Cuboid(double width, double length, double height) {
        super(width, length);
        if (height < 0) {
            this.height = 0;
        } else {
        this.height = height;
        }
    }
// METHODS
    public double getHeight() {
        return height;
    }

    public double getVolume () {
        return height*getArea();
    }
}
