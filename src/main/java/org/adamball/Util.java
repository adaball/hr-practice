package org.adamball;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Util {
  public static InputStream loadResourceAsStream(String resourcePath) throws FileNotFoundException {
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    InputStream resourceAsStream = contextClassLoader.getResourceAsStream(resourcePath);

    if (resourceAsStream == null) {
      throw new FileNotFoundException(String.format("Could not find resource file: %s", resourcePath));
    }

    return resourceAsStream;
  }
}
