package kettu;

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
  }

  private static void mightThrowInTheFutureExample() throws IOException {
  }

}
