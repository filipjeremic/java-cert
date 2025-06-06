package kettu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {

  {
    // initializers can't throw exceptions
    // throw new java.sql.SQLException();
    // throw new RuntimeException();
  }

  public static void runExamples() {
    try {
      mightThrowInTheFutureExample();
    } catch (IOException e) {
    }

    uncheckedExceptionsExample();
    nestedTryExample();
  }

  private static void mightThrowInTheFutureExample() throws IOException {
  }

  private static void uncheckedExceptionsExample() throws RuntimeException {
    System.out.println("Ignored by the compiler, no need for the try-catch block");
  }

  @SuppressWarnings("unused")
  private static void uncheckedExceptionsExample2() {
    throw new RuntimeException();
  }

  private static void nestedTryExample() {
    try {
      try {
        if (Math.random() > 0.5) {
          throw new FileNotFoundException();
        }
        System.out.println("Message #1");
      } finally {
        System.out.println("Message #2");
      }
      System.out.println("Message #3");
    } catch (FileNotFoundException e) {
      System.out.println("Message #4");
    } finally {
      System.out.println("Message #5");
    }
    System.out.println("Message #6");
  }

  @SuppressWarnings("unused")
  private static void tryWithResourcesExample() {

    try {
      FileReader fr = new FileReader("");
      fr.close();

      // the code won't compile if the FileReader line below is uncommented
      // because it makes fr not effectively final
      // fr = new FileReader("");

      try (fr; FileWriter fw = new FileWriter("");) {
      }
    } catch (IOException e) {
    }

    // but this is ok
    try {
      FileReader fr = new FileReader("");
      try (FileReader fr2 = fr; FileWriter fw = new FileWriter("")) {
      }
      fr = null;
    } catch (IOException e) {
    }

  }

}
