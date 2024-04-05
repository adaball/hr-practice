package org.adaball.datastructures;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-1d-array-introduction/problem">HR link</a>
 */
public class OneDimensionalArrays {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("datastructures/one-dimensional-arrays.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int nLines = Integer.parseInt(scanner.nextLine().trim());
    int[] intArray = new int[nLines];

    int idx = 0;
    while (nLines-- > 0) {
      intArray[idx++] = Integer.parseInt(scanner.nextLine().trim());
    }

    scanner.close();

    for (int i : intArray) {
      System.out.println(i);
    }
  }
}
