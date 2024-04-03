package org.adaball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-loops-i/problem">HR link</a>
 */
public class Loops1 {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/loops-1.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int n = scanner.nextInt();
    scanner.close();

    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d x %d = %d%n", n, i, n * i);
    }
  }
}
