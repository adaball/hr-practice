package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import org.adamball.Util;

public class Loops1 {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("loops-1.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int n = scanner.nextInt();
    scanner.close();

    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d x %d = %d%n", n, i, n * i);
    }
  }
}
