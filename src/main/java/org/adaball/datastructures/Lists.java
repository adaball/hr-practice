package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/lists.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);

        int listLength = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            intList.add(scanner.nextInt());
        }

        int numQueries = scanner.nextInt();

        for (int i = 0; i < numQueries; i++) {
            String operation = scanner.next();

            if ("Insert".equals(operation)) {
                int insertIdx = scanner.nextInt();
                int insertVal = scanner.nextInt();

                intList.add(insertIdx, insertVal);
            } else if ("Delete".equals(operation)) {
                int deleteIdx = scanner.nextInt();

                intList.remove(deleteIdx);
            }
        }

        System.out.println(String.join(" ",
                intList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toUnmodifiableList())));

    }
}
