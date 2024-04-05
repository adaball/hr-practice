package org.adaball.datastructures;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adaball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-2d-array/problem">HR link</a>
 */
public class TwoDimensionalArrays {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("datastructures/two-dimensional-arrays.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int[][] input = new int[6][6];
    int x = 0;
    int y = 0;
    while (scanner.hasNext()) {
      if (x > 5) {
        x = 0;
        y++;
        continue;
      }

      input[y][x++] = Integer.parseInt(scanner.next());
    }

    System.out.println(getMaxHourglassSum(input));
  }

  private static int getMaxHourglassSum(int[][] input) {
    int startX = 0;
    int startY = 0;
    int maxSum = Integer.MIN_VALUE;
    while (startY < 4) {
      int hourGlassSum = 0;

      hourGlassSum += input[startY][startX];
      hourGlassSum += input[startY][startX + 1];
      hourGlassSum += input[startY][startX + 2];
      hourGlassSum += input[startY + 1][startX + 1];
      hourGlassSum += input[startY + 2][startX];
      hourGlassSum += input[startY + 2][startX + 1];
      hourGlassSum += input[startY + 2][startX + 2];

      if (maxSum < hourGlassSum) {
        maxSum = hourGlassSum;
      }

      startX++;
      if (startX > 3) {
        startX = 0;
        startY++;
      }
    }
    return maxSum;
  }
}
