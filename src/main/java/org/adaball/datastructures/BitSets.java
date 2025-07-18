package org.adaball.datastructures;

import org.adaball.Util;

import java.io.InputStream;
import java.util.*;

public class BitSets {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("datastructures/bitsets.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);

        int bitSetSize = scanner.nextInt();
        int numOperations = scanner.nextInt();

        BitSet B1 = new BitSet(bitSetSize);
        BitSet B2 = new BitSet(bitSetSize);
        Map<Integer, BitSet> bitSetMapping = new HashMap<>();
        bitSetMapping.put(1, B1);
        bitSetMapping.put(2, B2);

        for (int i = 0; i < numOperations; i++) {
            String operation = scanner.next();
            int operand1 = scanner.nextInt();
            int operand2 = scanner.nextInt();

            BitSet firstSet = bitSetMapping.get(operand1);
            BitSet secondSet = bitSetMapping.get(operand2);

            // the BitSet resulting from the operation replaces
            // the contents of the first operand.
            switch (operation) {
                case "AND":
                    firstSet.and(secondSet);
                    break;
                case "OR":
                    firstSet.or(secondSet);
                    break;
                case "XOR":
                    firstSet.xor(secondSet);
                    break;
                case "FLIP":
                    firstSet.flip(operand2);
                    break;
                case "SET":
                    firstSet.set(operand2);
                    break;
                default:
                    break;
            }

            System.out.printf("%d %d\n", B1.cardinality(), B2.cardinality());
        }
    }
}
