package org.adamball.strings;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-string-compare/problem">HR link</a>
 */
public class SubstringCompare {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/substring-compare.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    String s = scanner.nextLine();
    int k = scanner.nextInt();
    scanner.close();

    System.out.println(getSmallestAndLargest(s, k));
  }

  // Given a string, s, and an integer, k, complete the function
  // so that it finds the lexicographically smallest and largest substrings of length k.
  public static String getSmallestAndLargest(String s, int k) {
    int bottom = 0;
    int top = k;
    int arrayLength = s.length() - (k - 1);
    String[] subStrings = new String[arrayLength];

    int i = 0;
    while (top <= s.length()) {
      subStrings[i++] = s.substring(bottom++, top++);
    }

    String lowest = subStrings[0];
    String highest = subStrings[0];
    for (String sub : subStrings) {
      if (sub == null) {
        break;
      }

      lowest = sub.compareTo(lowest) < 0 ? sub : lowest;
      highest = sub.compareTo(highest) > 0 ? sub : highest;
    }

    return String.format("%s%n%s", lowest, highest);
  }
}
