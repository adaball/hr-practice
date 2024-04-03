package org.adamball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-regex/problem">HR link</a>
 */
public class Regex {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/regex.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    while (scanner.hasNext()) {
      System.out.println(MyRegex.validIPAddress(scanner.nextLine().trim()));
    }

    scanner.close();
  }

  private static class MyRegex {
    // IP address is a string in the form "A.B.C.D", where the value of A, B, C,
    // and D may range from 0 to 255. Leading zeros are allowed. The length of
    // A, B, C, or D can't be greater than 3.
    // \d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}
    private static final Pattern IP_ADDRESS_PATTERN =
        Pattern.compile(
            "^(?:(?:2[0-4][0-9]|25[0-5]|[0-1][0-9]{1,2}|[0-9]{1,2})\\.){3}(?:(?:2[0-4][0-9]|25[0-5]|[0-1][0-9]{1,2}|[0-9]{1,2}))$");

    private static boolean validIPAddress(String s) {
      return IP_ADDRESS_PATTERN.asPredicate().test(s);
    }
  }
}
