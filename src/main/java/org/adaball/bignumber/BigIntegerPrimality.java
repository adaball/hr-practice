package org.adaball.bignumber;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-primality-test/problem">HR link</a>
 */
public class BigIntegerPrimality {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("bignumber/big-integer-primality.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    scanner.close();
    System.out.println(new BigInteger(scanner.nextLine()).isProbablePrime(8) ? "prime" : "not prime");
  }
}
