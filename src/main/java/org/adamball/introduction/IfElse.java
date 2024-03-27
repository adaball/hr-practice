package org.adamball.introduction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-if-else/problem"> HR link</a>
 */
public class IfElse {
  public static void main(String[] args) {

    InputStream inputStream;
    try {
      inputStream = Util.loadResourceAsStream("if-else.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    int i;
    try {
      i = Integer.parseInt(bufferedReader.readLine().trim());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      bufferedReader.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    boolean even = i % 2 == 0;
    if (!even || (i >= 6 && i <= 20)) {
      System.out.println("Weird");
      return;
    }

    if ((i >= 2 && i <= 5) || i > 20) {
      System.out.println("Not Weird");
    }
  }
}
