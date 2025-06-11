package kettu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

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
    autoCloseableExample();

    try {
      lostExceptionExample();
    } catch (InterruptedException | IOException e) {
      System.out.println(e);
      System.out.println(e.getSuppressed().length);
    }

    suppressedExceptionsExample();
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

  @SuppressWarnings("unused")
  private static void multiCatchExample() {
    try {
      if (Math.random() < 0.5) {
        throw new FileNotFoundException();
      }

      if (Math.random() < 0.5) {
        throw new SQLFeatureNotSupportedException();
      }
    } catch (FileNotFoundException | SQLFeatureNotSupportedException e) {
    }
  }

  @SuppressWarnings("unused")
  private static void rethrowExample1() throws FileNotFoundException, SQLException {
    try {
      if (Math.random() < 0.5) {
        throw new FileNotFoundException();
      }

      if (Math.random() < 0.5) {
        throw new SQLException();
      }
    } catch (IOException | SQLException e) {
      System.out.println(e.getClass().getName());
      throw e;
    }
  }

  @SuppressWarnings("unused")
  private static void rethrowExample2() throws Exception {
    try {
      if (Math.random() < 0.5) {
        throw new FileNotFoundException();
      }

      if (Math.random() < 0.5) {
        throw new SQLException();
      }
    } catch (IOException | SQLException e) {
      System.out.println(e.getClass().getName());
      final Exception ex = e;
      System.out.println(ex.getClass().getName());
      throw ex;
      // we are throwing ex, not e
      // because of that we have 'throws Exception' in the method signature
      // and not 'throws FileNotFoundException, SQLException'
    }
  }

  @SuppressWarnings("finally")
  private static void lostExceptionExample() throws InterruptedException, IOException {
    try {
      throw new InterruptedException();
    } catch (InterruptedException e) {
      throw new InterruptedException("catch block exception"); // this exception is lost
    } finally {
      throw new IOException("finally block exception");
    }
  }

  static class MyAutoCloseable implements AutoCloseable {

    private static int NEXT_ID = 0;
    private int id = NEXT_ID++;

    MyAutoCloseable() {
      System.out.println("Constructing " + id);
    }

    @Override
    public void close() throws IOException {
      if (id == 1) {
        throw new IOException();
      }
      System.out.println("Closing " + id);
    }

  }

  private static void autoCloseableExample() {
    System.out.println("Function start");
    final MyAutoCloseable mac0 = new MyAutoCloseable();
    try (final MyAutoCloseable mac1 = new MyAutoCloseable();
        mac0;
        final MyAutoCloseable mac2 = new MyAutoCloseable();) {
      System.out.println("In the try block");
    } catch (IOException e) {
      System.out.println("In the catch block");
    }
    System.out.println("Function end");
  }

  static class MyOtherAutoCloseable implements AutoCloseable {

    private static int NEXT_ID = 0;
    private int id = NEXT_ID++;

    {
      System.out.println("id = " + id);
    }

    @Override
    public void close() throws SQLException, IOException, InterruptedException {
      System.out.println("Closing " + id);

      switch (id % 3) {
        case 0 -> throw new SQLException();
        case 1 -> throw new IOException();
        case 2 -> throw new InterruptedException();
      }
    }

  }

  private static void suppressedExceptionsExample() {
    try (
        final MyOtherAutoCloseable c0 = new MyOtherAutoCloseable();
        final MyOtherAutoCloseable c1 = new MyOtherAutoCloseable();
        final MyOtherAutoCloseable c2 = new MyOtherAutoCloseable();) {
      throw new IOException("try block exception");
    } catch (SQLException | IOException | InterruptedException e) {
      System.out.println(e);
      for (final Throwable suppressedException : e.getSuppressed()) {
        System.out.println(suppressedException);
      }
    }
  }

}
