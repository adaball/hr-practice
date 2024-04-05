package org.adaball.bignumber;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-biginteger/problem">HR link</a>
 */
public class BigIntegerMath {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("bignumber/big-integer-math.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    BigInteger a = new BigInteger(scanner.nextLine());
    BigInteger b = new BigInteger(scanner.nextLine());

    scanner.close();

    System.out.println(a.add(b));
    System.out.println(a.multiply(b));
  }
}
