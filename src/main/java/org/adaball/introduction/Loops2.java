package org.adaball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for <a href="https://www.hackerrank.com/challenges/java-loops/problem">HR link/a>
 */
public class Loops2 {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/loops-2.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int q = scanner.nextInt();

    // a+2^0*b
    // a+2^0*b+2^1*b
    // a+2^0*b+2^1*b+2^2*b
    // ...

    for (int i = 0; i < q; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int n = scanner.nextInt();

      int result = a;

      for (int j = 0; j < n; j++) {
        result += (int) (Math.pow(2, j) * b);
        System.out.print(result + " ");
      }
      System.out.print("\n");
    }
  }
}
