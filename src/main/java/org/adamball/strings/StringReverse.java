package org.adamball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-string-reverse/problem">HR link</a>
 */
public class StringReverse {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/string-reverse.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    String s = scanner.next();
    scanner.close();
    StringBuilder sb = new StringBuilder();

    String[] tokens = s.split("");
    for (int i = tokens.length - 1; i >= 0; i--) {
      sb.append(tokens[i]);
    }

    System.out.println(sb.toString().equals(s) ? "Yes" : "No");
  }
}
