package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-int-to-string/problem">HR link</a>
 */
public class IntToString {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/int-to-string.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    int n = scanner.nextInt();
    scanner.close();

    String s = String.valueOf(n);

    if (n == Integer.parseInt(s)) {
      System.out.println("Good job");
    } else {
      System.out.println("Wrong answer.");
    }
  }
}
