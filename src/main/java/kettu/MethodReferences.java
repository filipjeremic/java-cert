package kettu;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {

  private int x;

  MethodReferences(final int x) {
    this.x = x;
  }

  private static void staticPrint(final int number) {
    System.out.print(number + " ");
  }

  private void instancePrint(final int number) {
    System.out.print(x + number + " ");
  }

  public static void staticMethodReferences() {

    System.out.println("----- staticMethodReferences -----");

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // Using a lambda
    numbers.forEach(number -> staticPrint(number));
    System.out.println();

    // Using a method reference
    numbers.forEach(MethodReferences::staticPrint);
    System.out.println();

    System.out.println();

  }

  public static void instanceMethodReferences() {

    System.out.println("----- instanceMethodReferences -----");

    MethodReferences methodReferences = new MethodReferences(100);

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    numbers.forEach(methodReferences::instancePrint);
    System.out.println();

    System.out.println();

  }

}
