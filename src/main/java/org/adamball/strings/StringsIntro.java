package org.adamball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-strings-introduction/problem">HR link</a>
 */
public class StringsIntro {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/strings-intro.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    String a = scanner.next();
    String b = scanner.next();
    scanner.close();

    int lengthSum = a.length() + b.length();
    String aBeforeB = a.compareTo(b) > 0 ? "Yes" : "No";

    System.out.println(lengthSum);
    System.out.println(aBeforeB);
    System.out.printf("%s%s %s%s%n",
        a.substring(0, 1).toUpperCase(), a.substring(1),
        b.substring(0, 1).toUpperCase(), b.substring(1));
  }
}
