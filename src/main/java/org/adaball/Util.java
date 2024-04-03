package org.adaball;

import java.io.InputStream;
import java.util.MissingResourceException;

public class Util {
  public static InputStream loadResourceAsStream(String resourcePath) throws MissingResourceException {
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    InputStream resourceAsStream = contextClassLoader.getResourceAsStream(resourcePath);

    if (resourceAsStream == null) {
      throw new MissingResourceException("Unable to load resource file", Util.class.getName(), resourcePath);
    }

    return resourceAsStream;
  }
}
