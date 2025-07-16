package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Maps {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/maps.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        /**
         * uncle sam=99912222
         * Not found
         * harry=12299933
         */

        Scanner scanner = new Scanner(inputStream);

        int numEntries = scanner.nextInt();
        Map<String, Integer> phoneBook = new HashMap<>();
        scanner.nextLine();

        for (int i = 0; i < numEntries; i++) {
            String name = scanner.nextLine();
            int number = scanner.nextInt();

            phoneBook.put(name, number);
            scanner.nextLine();
        }

        while (scanner.hasNext()) {
            String query = scanner.nextLine();
            Integer number = phoneBook.get(query);

            if (number == null) {
                System.out.println("Not found");
            } else {
                System.out.printf("%s=%d\n", query, number);
            }
        }
    }
}
