package org.adamball.introduction;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-static-initializer-block/problem">HR link</a>
 */
public class StaticInitBlock {
  private static final int B;
  private static final int H;
  private static boolean flag;

  // sort of an odd thing to put in a static block, but that's what the solution calls for :shrug:
  static {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/static-init-block.txt");
    } catch (MissingResourceException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);
    B = scanner.nextInt();
    H = scanner.nextInt();
    scanner.close();

    if (B > 0 && H > 0) {
      flag = true;
    } else {
      System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
  }

  // nb. this part is non-editable in the HR solution editor and thus I'm forced to use it as is.
  public static void main(String[] args) {
    if (flag) {
      int area = B * H;
      System.out.print(area);
    }
  }
}
