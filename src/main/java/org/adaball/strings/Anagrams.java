package org.adaball.strings;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-anagrams/problem">HR link</a>
 * <br />
 * Note: HR submission interface for Java 8 doesn't allow for any additional imports save the Scanner so this
 * solution is done in arrays.  I could use a higher Java version but I'm choosing not to because of HR's checking
 * weirdness between versions.  Probably making this hard on myself 🤷‍♀️
 */
public class Anagrams {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("strings/anagrams.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    String a = scanner.next();
    String b = scanner.next();
    scanner.close();

    System.out.println(areAnagrams(a, b) ? "Anagrams" : "Not Anagrams");
  }

  /**
   * Returns true if a and b are case-insensitive anagrams.
   *
   * @param a first string for comparison
   * @param b second string for comparison
   * @return Whether or not a and b are case-insensitive anagrams
   */
  private static boolean areAnagrams(String a, String b) {
    String lowerA = a.toLowerCase();
    String lowerB = b.toLowerCase();

    int[][] aCharFrequencies = getCharacterFrequency(lowerA);
    int[][] bCharFrequencies = getCharacterFrequency(lowerB);

    // are all of A chars found in B chars?
    boolean aInB = true;
    for (int[] aFrequency : aCharFrequencies) {
      if (equalFrequency(aFrequency, bCharFrequencies)) {
        continue;
      }

      aInB = false;
    }

    // return early if the first case is false
    if (!aInB) {
      return false;
    }

    // are all of B chars found in A chars?
    boolean bInA = true;
    for (int[] bFrequency : bCharFrequencies) {
      if (equalFrequency(bFrequency, aCharFrequencies)) {
        continue;
      }

      bInA = false;
    }

    return bInA;
  }

  /**
   * Checks if a character frequency is found in an array of character frequencies.
   *
   * @param frequencyToCheck single char frequency, format [char's int code, char's frequency]
   * @param frequencies      array of char frequencies
   * @return whether or not the given frequency is found in the given array of frequencies (both present in code and
   * in the frequency amount)
   */
  private static boolean equalFrequency(int[] frequencyToCheck, int[][] frequencies) {
    for (int[] frequency : frequencies) {
      if (frequency[0] == frequencyToCheck[0] && frequency[1] == frequencyToCheck[1]) {
        return true;
      }
    }

    return false;
  }

  /**
   * Generate character frequencies for the given string.
   *
   * @param s string to analyze
   * @return int[][] where each entry's format is [char's int code, char's frequency in string]
   */
  private static int[][] getCharacterFrequency(String s) {
    char[] stringChars = new char[s.length()];
    s.getChars(0, s.length(), stringChars, 0);

    // data format: [0] int char code, [1] int freq
    int[][] charFrequencies = new int[s.length()][2];
    int charFrequenciesIdx = 0;

    // search charFrequencies for the given characters
    for (char stringChar : stringChars) {
      boolean found = false;
      int charIdx;
      for (charIdx = 0; charIdx < charFrequencies.length; charIdx++) {
        if (stringChar == charFrequencies[charIdx][0]) {
          found = true;
          break;
        }
      }

      // add or increment count for given character
      if (found) {
        int currCount = charFrequencies[charIdx][1];
        charFrequencies[charIdx][1] = currCount + 1;
      } else {
        charFrequencies[charFrequenciesIdx][0] = stringChar;
        charFrequencies[charFrequenciesIdx][1] = 1;
        charFrequenciesIdx++;
      }
    }

    // figure out the sizing for the final array
    int uniqueCharCount = 0;
    for (int[] charFrequency : charFrequencies) {
      if (charFrequency[0] != 0) {
        uniqueCharCount++;
      }
    }

    // only include found character frequencies in final array
    int[][] finalCharFrequencies = new int[uniqueCharCount][2];
    for (int i = 0; i < finalCharFrequencies.length; i++) {
      finalCharFrequencies[i] = new int[] {charFrequencies[i][0], charFrequencies[i][1]};
    }

    return finalCharFrequencies;
  }
}
