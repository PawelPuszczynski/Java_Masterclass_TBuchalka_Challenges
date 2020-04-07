package com.company;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Class bodyType;
    final Set<HeavenlyBody> satellites;



    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = this.getClass();
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public boolean addSatellite(HeavenlyBody satellite) {
        if (this == satellite) {
            return false;
        } else {
            return this.satellites.add(satellite);
        }
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Class getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals ( Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj ==null)|| (obj.getClass()!= this.getClass())){
            return false;
        }
        if (this.orbitalPeriod != ((HeavenlyBody)obj).getOrbitalPeriod() ||
                !this.bodyType.equals(((HeavenlyBody) obj).getBodyType())) {
            return false;
        } else {
            String objName = ((HeavenlyBody) obj).getName();

            return this.name.equals(objName);
        }
    }

    @Override
    public int hashCode() {

        return this.name.hashCode()+57;
    }
}

package com.company;


public class Star extends HeavenlyBody {


    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if ( satellite.getClass() != Star.class) {
            this.satellites.add(satellite);
            return true;

        } else {
            System.out.println("You cannot add Stars as satellites of a star");
            return false;
        }
    }
}
package com.company;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod){
        super(name, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getClass() == Moon.class) {
            this.satellites.add(satellite);
            return true;
        } else {
            System.out.println("You can add only Moon-type objects as Planet satellites");
            return false;
        }
    }
}

package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<HeavenlyBody> solarSystem = new HashSet<>();
    private static Set<Star> stars = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();

    public static void main(String[] args) {

       Star sun = new Star("Sun", 0);
       stars.add(sun);

        Planet mercury = new Planet ("Mercury" , 88);
        planets.add(mercury);
        sun.addSatellite(mercury);


        Planet venus = new Planet("Venus" , 225);
        planets.add(venus);
        sun.addSatellite(venus);


        Planet earth = new Planet("Earth" , 365);
        planets.add(earth);
        sun.addSatellite(earth);
//        Planet earth2 = new Planet("Earth",365);
//        planets.add(earth2);
//        sun.addSatellite(earth2);
//        Moon earth3 = new Moon ("Earth", 400);
//        moons.add(earth3);


        Moon moon = new Moon("Moon", 27);
        moons.add(moon);
        earth.addSatellite(moon);
//        Moon moon4 = new Moon("Moon", 30);
//        moons.add(moon4);
//        Planet moon2 = new Planet("Moon", 100);
//        moon.addSatellite(moon2);
//        moon.addSatellite(moon);
//
//        moon.addSatellite(earth3);

        Planet mars = new Planet("Mars", 687);
        planets.add(mars);
        sun.addSatellite(mars);
//        mars.addSatellite(earth);
//        mars.addSatellite(earth3);

        Moon deimos = new Moon("Deimos", 1.3);
        moons.add(deimos);
        mars.addSatellite(deimos);


        Moon phobos = new Moon("Phobos", 0.3);
        moons.add(phobos);
        mars.addSatellite(phobos);

        Planet jupiter = new Planet("Jupiter", 4332);
        planets.add(jupiter);
        sun.addSatellite(jupiter);

        Moon io = new Moon("Io", 1.8);
        moons.add(io);
        jupiter.addSatellite(io);

        Moon europa = new Moon("Europa", 3.5);
        moons.add(europa);
        jupiter.addSatellite(europa);

        Moon ganymede = new Moon("Ganymede", 7.1);
        moons.add(ganymede);
        jupiter.addSatellite(ganymede);

        Moon callisto = new Moon("Callisto", 16.7);
        moons.add(callisto);
        jupiter.addSatellite(callisto);

        Planet saturn = new Planet("Saturn", 10759);
        planets.add(saturn);
        sun.addSatellite(saturn);

        Planet uranus = new Planet("Uranus", 30660);
        planets.add(uranus);
        sun.addSatellite(uranus);

        Planet neptune = new Planet("Neptune", 165);
        planets.add(neptune);
        sun.addSatellite(neptune);

        Planet pluto = new Planet("Pluto", 248);
        planets.add(pluto);
        sun.addSatellite(pluto);

        solarSystem.addAll(stars);
        solarSystem.addAll(planets);
        solarSystem.addAll(moons);

        //  PRINT-OUT***********************************************************************
        System.out.println("\nPlanets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" +planet.getName());
        }

        System.out.println("\nMoons");
        for (HeavenlyBody moonSat : moons) {
            System.out.println("\t" +moonSat.getName());
        }

        System.out.println("\nMoons of "+ mars.getName());
        for (HeavenlyBody marsMoons : mars.getSatellites()) {
            System.out.println("\t" + marsMoons.getName());

        }
        System.out.println("\nMoons of "+ jupiter.getName());
        for (HeavenlyBody jupiterMoons : jupiter.getSatellites()) {
            System.out.println("\t" + jupiterMoons.getName());

        }
        System.out.println("\nSOLAR SYSTEM: ");
        for (HeavenlyBody x : solarSystem) {
            System.out.println(x.getName()+ ", orbital period: "+ x.getOrbitalPeriod() + ", body type: "
                    + x.getBodyType().getName().
                    replace("com.company.",""));

        }
     System.out.println("\nSatellites of the "+ sun.getName() + " : ");
        for  (HeavenlyBody s :sun.getSatellites()){
         System.out.println(s.getName() + " orbital period: "+ s.getOrbitalPeriod());
        }
     System.out.println("\nSatellites of the " + earth.getName()+ "  : ");
     for  (HeavenlyBody m :earth.getSatellites()){
      System.out.println(m.getName() + " orbital period: "+ m.getOrbitalPeriod());
     }


    }


}
