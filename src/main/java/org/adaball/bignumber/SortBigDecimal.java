package org.adaball.bignumber;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-bigdecimal/problem">HR link</a>
 */
public class SortBigDecimal {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("bignumber/sort-big-decimal.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    List<String> lines = new ArrayList<>();
    int nLines = Integer.parseInt(scanner.nextLine());
    while (nLines-- > 0) {
      String line = scanner.nextLine();
      lines.add(line);
    }

    scanner.close();

    lines.stream().sorted((a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a))).forEach(System.out::println);
  }
}
