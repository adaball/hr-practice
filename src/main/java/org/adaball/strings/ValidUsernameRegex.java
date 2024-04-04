package org.adaball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/valid-username-checker/problem">HR link</a>
 */
public class ValidUsernameRegex {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/valid-username-regex.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int numUsernames = Integer.parseInt(scanner.nextLine());
    while (numUsernames-- > 0) {
      String userName = scanner.nextLine();
      if (userName.matches("^[A-Za-z][\\w]{7,29}$")) {
        System.out.println("Valid");
        continue;
      }

      System.out.println("Invalid");
    }

    scanner.close();
  }
}
