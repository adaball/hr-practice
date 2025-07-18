package org.adaball.datastructures;

import org.adaball.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.MissingResourceException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Varags {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/varargs.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add add = new Add();
            add.add(n1,n2);
            add.add(n1,n2,n3);
            add.add(n1,n2,n3,n4,n5);
            add.add(n1,n2,n3,n4,n5,n6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Add {
        public void add(Integer... operands) {
            String collect = Stream.of(operands).map(String::valueOf).collect(Collectors.joining("+"));

            int sum = 0;
            for (Integer operand : operands) {
                sum += operand;
            }

            System.out.printf("%s=%d\n", collect, sum);
        }
    }
}
