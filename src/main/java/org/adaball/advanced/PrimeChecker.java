package org.adaball.advanced;

import org.adaball.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.stream.Collectors;

public class PrimeChecker {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("advanced/prime-checker.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        int n1;
        int n2;
        int n3;
        int n4;
        int n5;
        try {
            n1 = Integer.parseInt(br.readLine());
            n2 = Integer.parseInt(br.readLine());
            n3 = Integer.parseInt(br.readLine());
            n4 = Integer.parseInt(br.readLine());
            n5 = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Prime ob = new Prime();
        ob.checkPrime(n1);
        ob.checkPrime(n1, n2);
        ob.checkPrime(n1, n2, n3);
        ob.checkPrime(n1, n2, n3, n4, n5);
    }

    private static class Prime {
        private boolean isPrime(int i) {
            if (i == 1) return false;


            // naive check modulos starting with i, then i-1 until 1 is reached
            boolean isPrime = true;
            int divisor = i - 1;
            while (divisor > 1) {
                if (i % divisor == 0) {
                    isPrime = false;
                    break;
                }

                divisor--;
            }

            return isPrime;
        }

        public void checkPrime(Integer... inputs) {
            List<Integer> primesFound = new ArrayList<>();
            for (Integer i : inputs) {
                if (isPrime(i)) {
                    primesFound.add(i);
                }
            }


            if (primesFound.isEmpty()) {
                System.out.println();
            } else {
                String primeString = primesFound.stream().map(String::valueOf).collect(Collectors.joining(" "));
                System.out.println(primeString);
            }
        }
    }
}
