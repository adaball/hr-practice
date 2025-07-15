package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;

public class OneDimensionalArraysPt2 {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
//            inputStream = Util.loadResourceAsStream("datastructures/one-dimensional-arrays-2.txt");
            inputStream = Util.loadResourceAsStream("datastructures/1d-test.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);

        int numQueries = scanner.nextInt();
        List<int[]> games = new ArrayList<>();

        int queryNum = 1;
        for (int i = 0; i < numQueries; i++) {
            int gameSize = scanner.nextInt();
            int leap = scanner.nextInt();
            int[] game = new int[gameSize];
            for (int j = 0; j < gameSize; j++) {
                game[j] = scanner.nextInt();
            }

            games.add(game);


            System.out.printf("%s\n", canWin(leap, game) ? "YES" : "NO");
//            System.out.printf("%d:\t%s\n", queryNum, canWin(leap, game) ? "YES" : "NO");
        }
    }

    private static void showGame(int idx, int[] game) {
        StringBuilder sb = new StringBuilder();
        for (int i : game) {
            sb.append(String.format("%d ", i));
        }

        sb.append("\n");
        sb.append("  ".repeat(Math.max(0, idx)));
        sb.append(String.format("^ (idx %d)", idx));
        System.out.println(sb);
    }

    private static boolean canWin(int leap, int[] game) {
        Queue<Integer> gameQueue = new ArrayDeque<>();
        gameQueue.add(0);

        Map<Integer, Integer> idxCounts = new HashMap<>();

        boolean gameWon = false;
        while (!gameQueue.isEmpty() && !gameWon) {
            int pos;
            try {
                pos = gameQueue.remove();
            } catch (NoSuchElementException e) {
                System.out.print("no such element found in game queue");
                break;
            }

//            if (idxCounts.containsKey(pos)) {
//                idxCounts.compute(pos, (k, i) -> i + 1);
//            } else {
//                idxCounts.put(pos, 1);
//            }


            // which moves are possible?
            // back
            // forward
            // leap
            // win condition: on cell n - 1 OR cell + leap >= n
//            showGame(pos, game);
            if (pos - 1 >= 0 && game[pos - 1] == 0) {
                gameQueue.add(pos - 1);
            }
            if (pos + 1 < game.length && game[pos + 1] == 0) {
                gameQueue.add(pos + 1);
            }
            if (pos + leap < game.length && game[pos + leap] == 0) {
                gameQueue.add(pos + leap);
            }
            if (pos == game.length - 1 || pos + leap >= game.length) {
                gameWon = true;
            }

//            boolean repeatDetected = false;
//            for (Map.Entry<Integer, Integer> kv : idxCounts.entrySet()) {
//                if (kv.getValue() > 10000) {
//                    System.out.printf("idx %d found to have been visited more than 10000 times, ending%n", kv.getKey());
//                    repeatDetected = true;
//                    break;
//                }
//            }
//
//            if (repeatDetected) {
//                System.out.println("repeat detected, game lost");
//                break;
//            }
        }

        idxCounts.keySet().stream().sorted().forEach(k -> System.out.printf("%d:\t%d%n", k, idxCounts.get(k)));

        return gameWon;
    }
}
