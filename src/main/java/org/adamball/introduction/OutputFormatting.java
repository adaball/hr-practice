package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-output-formatting/problem">HR link</a>
 */
public class OutputFormatting {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/output-formatting.txt");
    } catch (FileNotFoundException e) {
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
