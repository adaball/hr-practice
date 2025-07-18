package org.adaball.advanced;

import org.adaball.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.MissingResourceException;

/**
 * incredibly janky question
 */
public class Access {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = Util.loadResourceAsStream("advanced/access.txt");
        } catch (MissingResourceException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        int num;
        try {
            num = Integer.parseInt(br.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Must be used to hold the reference of the instance of the class Solution.Inner.Private
        Object o;

        Class<?>[] declaredClasses = Access.Inner.class.getDeclaredClasses();
        Class<?> innerPrivate = declaredClasses[0];
        Constructor<?> declaredConstructor = innerPrivate.getDeclaredConstructors()[0];
        declaredConstructor.setAccessible(true);

        try {
            o = declaredConstructor.newInstance(new Inner());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%d is %s", num, ((Inner.Private) o).powerof2(num));
        System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
    }

    static class Inner {
        private static class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner
}
