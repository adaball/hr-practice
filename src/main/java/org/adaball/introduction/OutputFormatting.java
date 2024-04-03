package org.adaball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-output-formatting/problem">HR link</a>
 */
public class OutputFormatting {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/output-formatting.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    System.out.println("================================");
    while (scanner.hasNext()) {
      String s = scanner.next();
      int i = scanner.nextInt();

      System.out.printf("%-15s%03d%n", s, i);
    }
    System.out.println("================================");

    scanner.close();
  }
}
