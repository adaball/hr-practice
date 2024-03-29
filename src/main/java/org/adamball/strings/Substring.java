package org.adamball.strings;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-substring/problem">HR link</a>
 */
public class Substring {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/substring.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    String s = scanner.next();
    int begin = scanner.nextInt();
    int end = scanner.nextInt();
    scanner.close();

    System.out.println(s.substring(begin, end));
  }
}
