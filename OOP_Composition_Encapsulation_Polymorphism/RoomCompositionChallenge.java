package com.company;

public class Room {
    private String ceiling;
    private int walls;
    private String floor;
    private Window window;
    private Door door;
    private Desk desk;


    public Room(String ceiling, int walls, String floor, Window window, Door door, Desk desk) {
        this.ceiling = ceiling;
        this.walls = walls;
        this.floor = floor;
        this.window = window;
        this.door = door;
        this.desk = desk;
    }

    public void inventoryCheck() {
        System.out.println("The room has : " + walls + " walls, " + ceiling + " ceiling, " + floor + " floor");
        System.out.println(" State of doors and windows");
//        desk.checkDrawer();
//        getDesk().checkDrawer();
    }
        public void generalCheck () {
            System.out.println("Empty= "+desk.getDrawer().isEmpty()+ ", Open = "+ desk.getDrawer().isOpen());

                    }


    public String getCeiling() {
        return ceiling;
    }

    public int getWalls() {
        return walls;
    }

    public String getFloor() {
        return floor;
    }

    public Window getWindow() {
        return window;
    }

    public Door getDoor() {
        return door;
    }

    public Desk getDesk() {
        return desk;
    }
}
package com.company;

public class Window {

    private int glass;
    private Knob windowKnob;
    private boolean isOpen;

    public Window(int glass, Knob windowKnob, boolean isOpen) {
        this.glass = glass;
        this.windowKnob = windowKnob;
        this.isOpen = isOpen;
    }

    public int getGlass() {
        return glass;
    }

    public Knob getWindowKnob() {
        return windowKnob;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
package com.company;

public class Door {

    private String wood;
    private Knob doorKnob;
    private boolean isOpen;

    public Door(String wood, Knob doorKnob, boolean isOpen) {
        this.wood = wood;
        this.doorKnob = doorKnob;
        this.isOpen = isOpen;
    }
    private void doorStatus() {
        System.out.println("Door status: is open=" +isOpen );

    }

    public String getWood() {
        return wood;
    }

    public Knob getDoorKnob() {
        return doorKnob;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
package com.company;

public class Desk {

    private int workArea;
    private Drawer drawer;

    public Desk(int workArea, Drawer drawer) {
        this.workArea = workArea;
        this.drawer = drawer;
    }

    private void  checkDrawer () {
        System.out.println("Checking the drawer if it is opened/empty");
        System.out.println("Drawer status: is open = " +drawer.isOpen()+ " is empty = "+ drawer.isEmpty());

    }


    public int getWorkArea() {
        return workArea;
    }

    public Drawer getDrawer() {
        return drawer;
    }
}
package com.company;

public class Drawer {

    private double volume;
    private Knob knob;
    private boolean isEmpty;
    private boolean isOpen;

    public Drawer(double volume, Knob knob, boolean isEmpty, boolean isOpen) {
        this.volume = volume;
        this.knob = knob;
        this.isEmpty = isEmpty;
        this.isOpen = isOpen;
    }

    public void openDrawer (boolean isOpen) {
        if (isOpen) {
            System.out.println(" The drawer is open");
        } else {
            System.out.println(" The drawer is closed");
        }
    }

    public double getVolume() {
        return volume;
    }

    public Knob getKnob() {
        return knob;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
package com.company;

public class Knob {

    private int handle;
    private String lock;
    private boolean isLocked;

    public Knob(int handle, String lock, boolean isLocked) {
        this.handle = handle;
        this.lock = lock;
        this.isLocked = isLocked;
    }

    public void lockedKnob (boolean isLocked) {
        if (isLocked) {
            System.out.println("The drawer is locked");
        } else {
            System.out.println("The drawer knob is unlocked");
        }
    }

    public int getHandle() {
        return handle;
    }

    public String getLock() {
        return lock;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {


        Knob knob = new Knob(1, "patent", false);
        Drawer drawer = new Drawer(3.4, knob, true, false);
        Desk desk =new Desk(1, drawer);
        Window window = new Window(1, knob, true);
        Door door = new Door("oak",knob, true);

        Room room= new Room("concrete",4, "wooden",window, door, desk);


        room.inventoryCheck();
        System.out.println("****************************");
       //        room.getDesk().checkDrawer();

        room.generalCheck();




    }
}
