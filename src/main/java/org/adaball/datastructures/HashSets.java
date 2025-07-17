package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.HashSet;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.Set;

public class HashSets {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/hashsets.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        int numLines = scanner.nextInt();
        scanner.nextLine();

        Set<Set<String>> pairs = new HashSet<>();
        for (int i = 0; i < numLines; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            Set<String> innerSet = new HashSet<>();
            innerSet.add(tokens[0]);
            innerSet.add(tokens[1]);
            pairs.add(innerSet);

            System.out.println(pairs.size());
        }
    }
}
