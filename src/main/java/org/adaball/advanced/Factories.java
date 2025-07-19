package org.adaball.advanced;

import org.adaball.Util;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Factories {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("advanced/factories.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);


        //factory instantiates an object
        FoodFactory foodFactory = new FoodFactory();
        Food food = foodFactory.getFood(scanner.nextLine());


        System.out.println("The factory returned " + food.getClass().getSimpleName());
        System.out.println(food.getType());
    }

    private static class FoodFactory {
        public Food getFood(String order) {
            if ("pizza".equals(order)) {
                return new Pizza();
            } else if ("cake".equals(order)) {
                return new Cake();
            }

            return null;
        }
    }

    private interface Food {
        String getType();
    }

    private static class Pizza implements Food {
        public String getType() {
            return "Someone ordered a Fast Food!";
        }
    }

    private static class Cake implements Food {

        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }
}
