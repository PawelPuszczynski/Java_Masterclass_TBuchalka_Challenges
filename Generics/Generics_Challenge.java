package com.company;

public abstract class Team <L>  implements Comparable <Team<L>>{
    private  String name;
    private int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
    public int compareTo(Team<L> o){


        if (this.getPoints() > o.getPoints()) {
            return -1;
        } else if (this.getPoints() < o.getPoints()) {
            return 1;
        } else {
            return 0;
        }
}

}
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League <L extends Team>  {
    private String name;
    private ArrayList<L> teamsInLeague ;



    public League(String name) {
        this.name = name;
        this.teamsInLeague = new ArrayList<L>();

    }

    public boolean addTeam(L team) {
        if (teamsInLeague.contains(team)) {
            System.out.println((team).getName() + " is already listed in this league.\n");
            return false;
        } else {
            teamsInLeague.add(team);
            System.out.println(team.getName() + " entered the " + this.name + " league.\n");
            return true;
        }
    }


    public void printTeams() {

        System.out.println("List of teams " + this.name + " \n");
        if (teamsInLeague != null) {
            for (int i = 0; i < teamsInLeague.size(); i++) {
                System.out.println((i + 1) + ". " + teamsInLeague.get(i).getName() + " has " +
                        teamsInLeague.get(i).getPoints() + " points.");
            }
        }
        System.out.println("\n");
    }

    public void printSortedList () {

        Collections.sort(teamsInLeague);
        System.out.println("Ranking of "+ this.name +"\n");
        for (L l : teamsInLeague) {
            System.out.println("\n" +l.getName() + ": " + l.getPoints());
        }
        System.out.println(Collections.min(teamsInLeague).getName());


    }



}
package com.company;

public class BasketballTeam extends Team {

    public BasketballTeam(String name, int points) {
        super(name, points);
    }

}
package com.company;

public class SoccerTeam extends Team  {

    public SoccerTeam(String name, int points) {
        super(name, points);
    }

}
package com.company;

public class VolleyballTeam extends Team  {

    public VolleyballTeam(String name, int points) {
        super(name, points);
    }

}
package com.company;

public class Main {

    public static void main(String[] args) {
	BasketballTeam warsaw = new BasketballTeam("Legia Warszawa",11);
	BasketballTeam krakow = new BasketballTeam("Korona Krakow",200);
	BasketballTeam wroclaw  = new BasketballTeam("Slask Wroclaw",3);
	SoccerTeam lodz = new SoccerTeam("Widzew Lodz",44);
	SoccerTeam kielce = new SoccerTeam("Korona Kielce",500);
	SoccerTeam czestochowa = new SoccerTeam("Rakow Czestochowa",6);


League<BasketballTeam> basketballTeamLeague = new League<>("Basketball League");
basketballTeamLeague.addTeam(warsaw);
basketballTeamLeague.addTeam(krakow);
basketballTeamLeague.addTeam(wroclaw);
basketballTeamLeague.addTeam(warsaw);
//basketballTeamLeague.addTeam(kielce);
basketballTeamLeague.printTeams();
basketballTeamLeague.printSortedList();

League <SoccerTeam> soccerTeamLeague = new League<>("Soccer League");
soccerTeamLeague.addTeam(lodz);
soccerTeamLeague.addTeam(kielce);
soccerTeamLeague.addTeam(czestochowa);


soccerTeamLeague.printTeams();
soccerTeamLeague.printSortedList();
soccerTeamLeague.printTeams();


    }
}
