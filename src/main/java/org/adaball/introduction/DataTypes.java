package org.adaball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-datatypes/problem">HR link</a>
 */
public class DataTypes {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/data-types.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      try {
        long x = scanner.nextLong();
        System.out.println(x + " can be fitted in:");
        if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
          System.out.println("* byte");
        }
        if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
          System.out.println("* short");
        }
        if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
          System.out.println("* int");
        }

        System.out.println("* long");
      } catch (Exception e) {
        System.out.println(scanner.next() + " can't be fitted anywhere.");
      }
    }

    scanner.close();
  }
}
