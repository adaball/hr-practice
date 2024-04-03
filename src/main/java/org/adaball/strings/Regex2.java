package org.adaball.strings;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/duplicate-word/problem">HR link</a>
 * <br />
 * Note: this solution "works on my box" but I had trouble with getting it to work for the same input on HackerRank's
 * submission interface, so idk 🤷‍♀️.  This regex could be simplified a bit (e.g. don't need named groups) but the core
 * concepts are what was needed to solve (repeated words with word boundaries).
 */
public class Regex2 {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/regex-2.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int numLines = Integer.parseInt(scanner.nextLine());

    List<String> lines = new ArrayList<>();
    while (numLines-- > 0) {
      lines.add(scanner.nextLine());
    }

    scanner.close();

    Pattern pattern = Pattern.compile("(?<dupe>\\b\\w+\\b)( ?\\k<dupe>)+", Pattern.CASE_INSENSITIVE);

    for (String line : lines) {
      System.out.println(pattern.matcher(line).replaceAll("$1"));
    }
  }
}
