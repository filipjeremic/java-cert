package kettu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Streams {

  // Two different types of operation can be performed on a stream:
  // - intermediate (return another stream, used to chain operations)
  // - terminal (return anything other than a stream or void)

  public static void example1() {

    List<Integer> numbers = Arrays.asList(7, 4, 1, 2, 3, 9, 5);
    numbers.stream().sorted().forEach(System.out::println);

  }

  public static void example2() {

    System.out.println("----- example2 -----");

    List<String> cars = Arrays.asList("mercedes", "volvo", "porsche", "fiat", "zastava", "lada", "peugeot");
    System.out.println(cars);

    List<String> processedCars1 = processWithoutStreams(cars);
    System.out.println(processedCars1);

    List<String> processedCars2 = processWithStreams(cars);
    System.out.println(processedCars2);

    System.out.println();

  }

  static List<String> processWithoutStreams(List<String> cars) {
    List<String> processedCars = new ArrayList<>();
    for (final String car : cars) {
      String uppercaseCar = car.toUpperCase();
      if (uppercaseCar.startsWith("P")) {
        processedCars.add(uppercaseCar);
      }
    }
    java.util.Collections.sort(processedCars);
    return processedCars;
  }

  static List<String> processWithStreams(List<String> cars) {
    return cars.stream()
        .map(String::toUpperCase)
        .filter(item -> item.startsWith("P"))
        .sorted()
        .toList();
    // .toList() produces an unmodifiable list
    // to get a modifiable list use .collect(Collectors.toList())
  }

}
