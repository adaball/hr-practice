package org.adaball;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckResult {
    public static void main(String[] args) {
        InputStream mine;
        InputStream theirs;

        try {
            mine = Util.loadResourceAsStream("check-result-mine.txt");
            theirs = Util.loadResourceAsStream("check-result-theirs.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(mine);
        List<String> myLines = scanner.useDelimiter("\n").tokens().collect(Collectors.toUnmodifiableList());
        scanner = new Scanner(theirs);
        List<String> theirLines = scanner.useDelimiter("\n").tokens().collect(Collectors.toUnmodifiableList());

        if (myLines.size() != theirLines.size()) {
            throw new RuntimeException(String.format("line count mismatch: mine %d theirs %d", myLines.size(),
                    theirLines.size()));
        }

        List<Integer> failures = new ArrayList<>();
        for (int i = 0; i < myLines.size(); i++) {
            if (!myLines.get(i).equals(theirLines.get(i))) {
                failures.add(i);
            }
        }

        if (failures.isEmpty()) {
            System.out.println("results match!");
        } else {
            String failuresString = failures.stream().map(i -> String.valueOf(i + 1)).collect(Collectors.joining(", "));
            System.out.printf("result do not match, failure lines: %s", failuresString);
        }
    }
}
