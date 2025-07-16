package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/arraylist.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        int numberOfLines = scanner.nextInt();
        List<List<Integer>> lines = new ArrayList<>(numberOfLines);
        for (int i = 0; i < numberOfLines; i++) {
            int numberOfInts = scanner.nextInt();
            List<Integer> line = new ArrayList<>(numberOfInts);
            lines.add(line);
            for (int i1 = 0; i1 < numberOfInts; i1++) {
                line.add(scanner.nextInt());
            }
        }

        int numQueries = scanner.nextInt();

        for (int i = 0; i < numQueries; i++) {
            int lineNum = scanner.nextInt();
            int itemNum = scanner.nextInt();

            List<Integer> items = lines.get(lineNum - 1);
            if (items.isEmpty() || itemNum > items.size()) {
                System.out.println("ERROR!");
                continue;
            }

            System.out.println(items.get(itemNum - 1));
        }
    }
}
