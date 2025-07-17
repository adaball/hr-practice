package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Stacks {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/stacks.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        List<String> lines = scanner.useDelimiter("\n").tokens().collect(Collectors.toUnmodifiableList());

        for (String line : lines) {
            Stack<String> balanceStack = new Stack<>();
            String[] tokens = line.split("");
            balanceStack.push(tokens[0]);

            for (int i = 1; i < tokens.length; i++) {
                String token = tokens[i];

                if (balanceStack.isEmpty()) {
                    balanceStack.push(token);
                    continue;
                }

                switch (token) {
                    case "}":
                        if ("{".equals(balanceStack.peek())) {
                            balanceStack.pop();
                        }
                        break;
                    case ")":
                        if ("(".equals(balanceStack.peek())) {
                            balanceStack.pop();
                        }
                        break;
                    case "]":
                        if ("[".equals(balanceStack.peek())) {
                            balanceStack.pop();
                        }
                        break;
                    default:
                        balanceStack.push(token);
                        break;
                }
            }

            System.out.println(balanceStack.isEmpty() ? "true" : "false");
        }
    }
}
