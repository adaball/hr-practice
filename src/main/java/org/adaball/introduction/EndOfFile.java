package org.adaball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-end-of-file/problem">HR link</a>
 */
public class EndOfFile {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/end-of-file.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int i = 1;
    while (scanner.hasNext()) {
      System.out.printf("%d %s%n", i++, scanner.nextLine());
    }

    scanner.close();
  }
}
