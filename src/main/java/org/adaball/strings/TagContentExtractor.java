package org.adaball.strings;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/tag-content-extractor/problem">HR link</a>
 * This one had some nasty test cases, so I wrote a small util to compare my solution with a file containing the
 * expected output.  This helped me identify issues with the regex.
 */
public class TagContentExtractor {

  private static final boolean DEBUG = false;

  public static void main(String[] args) {
    InputStream inputStreamInput;
    InputStream inputStreamSolution;

    try {
      inputStreamInput = Util.loadResourceAsStream("strings/tag-content-extractor.txt");
      inputStreamSolution = Util.loadResourceAsStream("strings/tag-content-extractor-solution.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner inputScanner = new Scanner(inputStreamInput);
    Scanner solutionScanner = new Scanner(inputStreamSolution);

    List<String> solutionLines = new ArrayList<>();
    int solutionIdx = 0;
    while (solutionScanner.hasNext()) {
      solutionLines.add(solutionScanner.nextLine());
    }

    Pattern pattern = Pattern.compile("<([ -~]+)>([^><]+)</\\1>");
    int inputLineCount = Integer.parseInt(inputScanner.nextLine());

    while (inputLineCount-- > 0) {
      String inputLine = inputScanner.nextLine();
      Matcher matcher = pattern.matcher(inputLine);

      // if no valid content is found, print "None".
      if (!matcher.find()) {
        if (DEBUG) {
          solutionCheck(solutionLines.get(solutionIdx), "None", solutionIdx + 1);
        }

        System.out.println("None");
        solutionIdx++;
        continue;
      }

      // roll back after initial check
      matcher.reset();

      // For each line, print the content enclosed within valid tags.
      // If a line contains multiple instances of valid content, print out each instance of valid content on a new line.
      while (matcher.find()) {
        String actual = matcher.group(matcher.groupCount());

        if (DEBUG) {
          solutionCheck(solutionLines.get(solutionIdx), actual, solutionIdx + 1);
        }

        System.out.println(actual);
        solutionIdx++;
      }
    }
  }

  private static void solutionCheck(String expected, String actual, int fileLine) {
    System.out.printf(">>> Solution file line: %d%n", fileLine);
    System.out.printf(">>> Expected: %s%n", expected);
    System.out.printf(">>> Actual: %s%n", actual);
    System.out.printf(">>> Equal?: %b%n", Objects.equals(expected, actual));
  }
}
