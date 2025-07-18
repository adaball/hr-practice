package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.*;

/**
 * 535
 * 352
 * 523
 * 232
 * <p>
 * ----
 * 5 - 1
 * 53 - 2
 * 535 - 2
 * (5)352 - 3
 * (3)523 - 3
 * (5)232 - 2
 */
public class Dequeues {

    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/dequeues.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Deque<Integer> window = new ArrayDeque<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxUnique = 0;

        Scanner scanner = new Scanner(inputStream);

        int arrSize = scanner.nextInt();
        int windowSize = scanner.nextInt();
        Integer[] arr = new Integer[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        for (Integer curr : arr) {
            window.addLast(curr);

            // add or incriment
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

            // enforce window size
            if (window.size() > windowSize) {
                int removed = window.removeFirst();

                // remove or decrement
                Integer count = freq.get(removed);
                if (count == 1) {
                    freq.remove(removed);
                } else if (count > 1) {
                    freq.put(removed, count - 1);
                }
            }

            if (window.size() == windowSize) {
                maxUnique = Math.max(maxUnique, freq.size());
            }
        }

        System.out.println(maxUnique);
    }
}
