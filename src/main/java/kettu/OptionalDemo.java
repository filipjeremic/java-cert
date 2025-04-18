package kettu;

import java.util.Optional;

public class OptionalDemo {

  public static void runExamples() {
    valuePresentExample();
    valueNotPresentExample();
    nullableValueExample();
  }

  private static void valuePresentExample() {
    final Optional<String> presentName = Optional.of("John");
    if (presentName.isPresent()) {
      System.out.println("The name is present and it's value is: " + presentName.get());
    } else {
      System.out.println("The name is not present.");
    }

    presentName.ifPresent(name -> System.out.println(name + " was here!"));
  }

  private static void valueNotPresentExample() {
    final Optional<String> notPresentName = Optional.empty();
    if (notPresentName.isPresent()) {
      System.out.println("The name is present and it's value is: " + notPresentName.get());
    } else {
      System.out.println("The name is not present.");
    }
  }

  private static void nullableValueExample() {
    final Optional<String> nullName = Optional.ofNullable(null);
    System.out.println(nullName);
  }

}
