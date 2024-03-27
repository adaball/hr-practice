package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for <a href="https://www.hackerrank.com/challenges/java-stdin-stdout/problem">HR Link</a>
 */
public class StdInAndOut2 {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("std-in-and-out-2.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int i = scanner.nextInt();
    double d = scanner.nextDouble();

    scanner.nextLine();
    String s = scanner.nextLine();

    scanner.close();

    System.out.printf("String: %s%n", s);
    // The output of `printf` for a double isn't what HR is expecting.
    // Tried an embarrassing amount of different things to get `printf`
    // to match their expectations, but ultimately `println` is the answer :shrug:.
    System.out.println("Double: " + d);
    System.out.printf("Int: %d%n", i);
  }
}
