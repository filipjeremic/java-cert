package kettu;

import java.io.FileNotFoundException;
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

    uncheckedExceptionsExample1();
    nestedTryExample();
  }

  private static void mightThrowInTheFutureExample() throws IOException {
  }

  private static void uncheckedExceptionsExample1() throws RuntimeException {
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

}
