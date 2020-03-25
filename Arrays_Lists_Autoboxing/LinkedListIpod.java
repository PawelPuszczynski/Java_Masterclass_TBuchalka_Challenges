package com.company;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ipod {
    private Album album;
    private ArrayList<Album> listOfAlbums= new ArrayList<>();
    private LinkedList<Song> playList = new LinkedList<>();

    public Ipod() {
    }


    public void ipodPlays () {


        Scanner scanner = new Scanner(System.in);
                boolean quit = false;
                boolean isGoingForward = true;
        this.playList = new LinkedList<>();

        pickSongsToPlaylist ();

        ListIterator<Song> listIterator = playList.listIterator();

        printMainMenu();

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (!playList.isEmpty()) {
                switch (choice) {
                    case 1:
                        printMainMenu();
                        break;
                    case 2:

                            if (!isGoingForward) {
                                listIterator.next();
                            }
                            isGoingForward = true;

                            if (listIterator.hasNext()) {
                                System.out.println("Now playing next song: " + listIterator.next().getName());

                            } else {
                                System.out.println("End of playlist. ");
                                listIterator.previous();
                                isGoingForward = false;
                            }
                        break;
                    case 3:
                            if (isGoingForward) {
                                if (listIterator.hasPrevious()) {
                                    listIterator.previous();
                                }
                                isGoingForward = false;
                            }
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing previous song: " + listIterator.previous()
                                        .getName());
                            } else {
                                System.out.println("Reached beginning of playlist.");
                                isGoingForward = true;
                            }
                        break;
                    case 4:

                            if (!isGoingForward) {
                                if (listIterator.hasNext()) {
                                    System.out.println("Now playing 1: " + listIterator.next().getName());
                                }
                                isGoingForward = true;
                                break;
                            }
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing 2: " + listIterator.previous().getName());
                                isGoingForward = false;
                            } else {
                                System.out.println("Reached beginning of playlist.");
                                System.out.println("Now playing first song: " + listIterator.next().getName());
                                isGoingForward = true;
                            }
                        break;
                    case 5:
                        System.out.println("List of songs on the playlist: \n");
                        for (int i = 0; i < playList.size(); i++) {
                                System.out.println((i + 1) + ". " + playList.get(i).getName()
                                        +", duration: "+ playList.get(i).getDuration()+"\n");
                            }
                        break;
                    case 6:
                            if (!isGoingForward) {
                                System.out.println(listIterator.next().getName() + " has been " +
                                        "removed from playlist");
                                listIterator.remove();
                            } else {
                                System.out.println(listIterator.previous().getName() + " has been " +
                                        "removed from playlist");
                                listIterator.remove();
                            }
                        break;
                    case 7:
                        quit = true;
                        break;
                }
            } else {
                System.out.println("No songs added to the playlist.");
            }
        }
    }


    private void pickSongsToPlaylist(){
        boolean done =false;
        while(!done)  {
            Scanner scanner = new Scanner(System.in);
            if (!listOfAlbums.isEmpty()) {
                System.out.println("Albums available. Enter album number .");
                printAlbums();
            } else {
                System.out.println("No albums available on the ipod.");
            }
            int albumNumber = scanner.nextInt();
            if (!listOfAlbums.get(albumNumber-1).getAlbumArrayList().isEmpty()){
                Album pickedUpAlbum = listOfAlbums.get(albumNumber-1);
                System.out.println();
                System.out.println("Songs available on this album: "+ pickedUpAlbum.getName()+
                        "\n"+
                        "Enter song number to add it to the playlist. \n");
                pickedUpAlbum.printSongsInAblum();
            } else {
                System.out.println("No songs available on this album.");
            }

            int songNumber = scanner.nextInt();
            Song pickedUpSong = listOfAlbums.get(albumNumber-1).getAlbumArrayList().get(songNumber-1);
            if (addToPlayList(pickedUpSong))
            {
                System.out.println("Song : "+pickedUpSong.getName()+" successfully added to the playlist.");

            } else {
                System.out.println("This song is already added to the playlist");
            }
            System.out.println("Press 1 to pick next song, press 0 when done.");
            int finished = scanner.nextInt();
            if(finished==0) {done = true;}
        }
    }

    private boolean addToPlayList(Song song) {
        if (this.playList.contains(song)) {
            return false;
        } else {
            playList.add(song);
            return true;
        }
    }

    private void printMainMenu() {
        System.out.println("Ipod. Main Menu \n"+
                "1 - Print main menu,\n"+
                "2 - Skip forward to the next song,\n"+
                "3 - Skip backwards to the prievious song\n"+
                "4 - Replay current song, \n"+
                "5 - List of all songs,\n"+
                "6 - Remove current song,\n"+
                "7 - Quit");
    }

    public void AddToAlbumList(Album album) {
        this.listOfAlbums.add(album);
        System.out.println("New album : "+ album.getName()+ " added to ipod.");
    }

    private void printAlbums() {
        for (int i = 0; i < listOfAlbums.size(); i++) {
            System.out.println((i + 1) + ". " + listOfAlbums.get(i).getName() + "\n");
        }
    }
 }
package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private ArrayList<Song> albumArrayList= new ArrayList<>();

    public Album(String name) {
        this.name = name;
    }

    public ArrayList<Song> getAlbumArrayList() {
        return albumArrayList;
    }

     public String getName() {
        return name;
    }

    public void addSongToAlbum(String songName, String songDuration) {
        Song song = new Song(songName,songDuration);
        this.albumArrayList.add(song);
        System.out.println("Song " + song.getName()+ " added to album "+ name +".");

    }
    public void printSongsInAblum() {
        for (int i = 0; i < albumArrayList.size(); i++) {

            System.out.println((i + 1) + ". " + albumArrayList.get(i).getName() + "\n");

        }
    }
}
package com.company;

public class Song {
    private String name;
    private String duration;

    public Song(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

      public String getDuration() {
        return duration;
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {

        Ipod ipod = new Ipod();

        Album album = new Album("Mild");

        album.addSongToAlbum( "aaa", "1:10");
        album.addSongToAlbum("bbb", "2:20");
        album.addSongToAlbum("ccc", "3:30");

        Album album1 = new Album("Wild");

        album1.addSongToAlbum("rrr", "4:40");
        album1.addSongToAlbum("www", "5:50");
        album1.addSongToAlbum("yyy", "6:60");

        ipod.AddToAlbumList(album);
        ipod.AddToAlbumList(album1);

        ipod.ipodPlays();

    }

}
