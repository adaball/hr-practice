package org.adamball.strings;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/pattern-syntax-checker/problem">HR link</a>
 */
public class PatternSyntax {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/pattern-syntax.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    List<String> sList = new ArrayList<>();
    while (scanner.hasNext()) {
      sList.add(scanner.nextLine().trim());
    }
    scanner.close();

    List<String> outputStrings = new ArrayList<>();
    for (String patternString : sList.subList(1, sList.size())) {
      try {
        Pattern.compile(patternString);
        outputStrings.add("Valid");
      } catch (PatternSyntaxException e) {
        outputStrings.add("Invalid");
      }
    }

    for (String s : outputStrings) {
      System.out.println(s);
    }
  }
}
