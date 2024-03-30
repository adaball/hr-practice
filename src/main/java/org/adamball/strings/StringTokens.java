package org.adamball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-string-tokens/problem">HR link</a>
 */
public class StringTokens {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/string-tokens.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    String s;
    try {
      s = scanner.nextLine();
    } catch (NoSuchElementException e) {
      s = null;
    } finally {
      scanner.close();
    }

    if (s == null || s.isEmpty() || s.isBlank()) {
      System.out.println(0);
      return;
    }

    String inverseTokenRegex = "[^A-Za-z]+";
    String[] tokens = s.trim().split(inverseTokenRegex);

    System.out.println(tokens.length);
    for (String token : tokens) {
      System.out.println(token);
    }
  }
}
