package kettu;

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

}
