package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-end-of-file/problem">HR link</a>
 */
public class EndOfFile {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/end-of-file.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int i = 1;
    while (scanner.hasNext()) {
      System.out.printf("%d %s%n", i++, scanner.nextLine());
    }

    scanner.close();
  }
}
