package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;

public class OneDimensionalArraysPt2 {
    private static List<Integer> solutions;
    private static Set<Integer> previousIValues;
    private static boolean solutionFound;


    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/one-dimensional-arrays-2.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);

        int numQueries = scanner.nextInt();
        for (int i = 0; i < numQueries; i++) {
            int gameSize = scanner.nextInt();
            int leap = scanner.nextInt();
            int[] game = new int[gameSize];
            for (int j = 0; j < gameSize; j++) {
                game[j] = scanner.nextInt();
            }

            solutions = new ArrayList<>();
            previousIValues = new HashSet<>();
            solutionFound = false;
            System.out.printf("%s\n", canWin(leap, game) ? "YES" : "NO");
        }
    }

    private static void backtrack(int leap, int[] game, int i) {
        if (solutionFound) return;

        // cases in which its an invalid move
        if (i < 0 || i >= game.length || game[i] != 0 || previousIValues.contains(i)) {
            previousIValues.add(i);
            return;
        }

        previousIValues.add(i);

        // i is last cell or i+leap is beyond
        if (i >= game.length - 1 || i + leap >= game.length) {
            solutions.add(i);
            solutionFound = true;
            return;
        }

        backtrack(leap, game, i + 1);
        backtrack(leap, game, i - 1);
        backtrack(leap, game, i + leap);
    }

    private static boolean canWin(int leap, int[] game) {
        backtrack(leap, game, 0);
        return solutionFound;
    }
}
