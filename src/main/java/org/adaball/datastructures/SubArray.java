package org.adaball.datastructures;

import org.adaball.Util;

import java.io.*;
import java.util.*;

public class SubArray {

    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/sub-array.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        int arrayLength = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] stringArray = line.split(" ");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        assert arrayLength == intArray.length;

        int totalNegativeSubArrays = 0;

        // track the difference between lower and upper
        for (int difference = 0; difference < arrayLength; difference++) {
            int lower = 0;

            // generate the ALL lower and upper bounds using the difference
            for (int i = 0; i < intArray.length; i++) {
                int upper = lower + difference;
                if (upper >= intArray.length) break;

                // retrieve the values for the values between lower and upper bounds, inclusive
                int sum = 0;
                for (int j = lower; j <= upper; j++) {
                    sum += intArray[j];
                }

                // calculate the nubmer of negative sums that are found
                if (sum < 0) {
                    totalNegativeSubArrays++;
                }

                lower++;
            }
        }

        System.out.println(totalNegativeSubArrays);
    }
}
