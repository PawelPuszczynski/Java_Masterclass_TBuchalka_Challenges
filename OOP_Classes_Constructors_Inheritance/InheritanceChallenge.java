
public class Vehicle {
// FIELDS
    private int wheels;
    private int windows;
    private String propulsion;
    private double trunk;

// CONSTRUCTORS
   public Vehicle (){//no-arg constructor
       
   }
   
    public Vehicle(int wheels, int windows, String propulsion, double trunk) {
        this.wheels = wheels;
        this.windows = windows;
        this.propulsion = propulsion;
        this.trunk = trunk;
    }

//METHODS
    public void move (int speed){
        System.out.println("Vehicle.move () called");

    }

   public void gears(int gear){
        System.out.println("Vehicle.gear () called");

    }
   public void steer (){
        System.out.println("Vehicle.steer () called");

    }


// GETTERS AND SETTERS
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public String getEngine() {
        return propulsion;
    }

    public void setEngine(String propulsion) {
        this.propulsion = propulsion;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public double getTrunk() {
        return trunk;
    }

    public void setTrunk(double trunk) {
        this.trunk = trunk;
    }
}


public class Car extends Vehicle {

private int steeringWheel;
private int dashboard;
private int airConditioning;

// CONSTRUCTORS


    public Car (){

    }

    public Car(int steeringWheel, int dashboard, int airConditioning) {
        this.steeringWheel = steeringWheel;
        this.dashboard = dashboard;
        this.airConditioning = airConditioning;
    }

    public Car( String propulsion, double trunk, int steeringWheel, int dashboard, int airConditioning) {
        super(4,3, propulsion, trunk);
        this.steeringWheel = steeringWheel;
        this.dashboard = dashboard;
        this.airConditioning = airConditioning;
    }

    //METHODS

    public void autoGearbox (int gear){
        System.out.println("Car.autoGearbox () called");
    }

    @Override
    public void gears(int gear) {
        System.out.println("Vehicle.gears () called");
        autoGearbox(gear);
        super.gears(gear);
    }



    // GETTERS AND SETTERS
    public int getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(int steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public int getDashboard() {
        return dashboard;
    }

    public void setDashboard(int dashboard) {
        this.dashboard = dashboard;
    }

    public int getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(int airConditioning) {
        this.airConditioning = airConditioning;
    }
}




public class Tesla extends Car {

public int bigLcdScreen;
public int batteries;
public int wifi;

// CONSTRUCTORS


    public Tesla(int bigLcdScreen, int batteries, int wifi) {
        this.bigLcdScreen = bigLcdScreen;
        this.batteries = batteries;
        this.wifi = wifi;
    }

    public Tesla(int steeringWheel, int dashboard, int airConditioning, int bigLcdScreen, int batteries, int wifi) {
        super(steeringWheel, dashboard, airConditioning);
        this.bigLcdScreen = bigLcdScreen;
        this.batteries = batteries;
        this.wifi = wifi;
    }

    public Tesla( double trunk, int steeringWheel, int dashboard, int airConditioning, int bigLcdScreen, int batteries, int wifi) {
        super("electric", trunk, steeringWheel, dashboard, airConditioning);
        this.bigLcdScreen = bigLcdScreen;
        this.batteries = batteries;
        this.wifi = wifi;
    }

    // METHODS
    public void autodrive () {
        System.out.println("Tesla.autodrive () called");
    }

    @Override
    public void move(int speed) {
        autodrive();

        super.move(speed);

    }

    // GETTERS AND SETTERS
    public int getBigLcdScreen() {
        return bigLcdScreen;
    }

    public void setBigLcdScreen(int bigLcdScreen) {
        this.bigLcdScreen = bigLcdScreen;
    }

    public int getBatteries() {
        return batteries;
    }

    public void setBatteries(int batteries) {
        this.batteries = batteries;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }
}
