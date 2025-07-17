package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Comparators {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/comparators.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scan = new Scanner(inputStream);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        // sort by score DESC
        // on a tie, sort alphabetically by name
        if (o1.score > o2.score) {
            return -1;
        } else if (o1.score < o2.score) {
            return 1;
        }

        return o1.name.compareTo(o2.name);
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
