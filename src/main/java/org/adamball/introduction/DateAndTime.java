package org.adamball.introduction;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import org.adamball.Util;

/**
 * Solution for: <a href="https://www.hackerrank.com/challenges/java-date-and-time/problem?isFullScreen=true">HR link</a>
 */
public class DateAndTime {
  public static void main(String[] args) {
    InputStream inputStream;

    try {
      inputStream = Util.loadResourceAsStream("introduction/date-and-time.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    Scanner scanner = new Scanner(inputStream);

    int month = scanner.nextInt();
    int day = scanner.nextInt();
    int year = scanner.nextInt();
    String dayOfWeek = findDay(month, day, year);

    System.out.println(dayOfWeek);
  }

  /*
   * Complete the 'findDay' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER month
   *  2. INTEGER day
   *  3. INTEGER year
   */

  public static String findDay(int month, int day, int year) {
    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));

    calendar.set(Calendar.MONTH, month - 1); // month is zero indexed
    calendar.set(Calendar.DATE, day);
    calendar.set(Calendar.YEAR, year);
    String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);

    return dayOfWeek.toUpperCase();
  }
}
