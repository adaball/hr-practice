package org.adamball.introduction;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-currency-formatter/problem">HR link</a>
 */
public class CurrencyFormatter {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/currency-formatter.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    double payment = scanner.nextDouble();
    scanner.close();

    NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat inrFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
    NumberFormat cnyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
    NumberFormat eurFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

    System.out.printf("US: %s%n", usdFormat.format(payment));
    System.out.printf("India: %s%n", inrFormat.format(payment));
    System.out.printf("China: %s%n", cnyFormat.format(payment));
    System.out.printf("France: %s%n", eurFormat.format(payment));
  }
}
