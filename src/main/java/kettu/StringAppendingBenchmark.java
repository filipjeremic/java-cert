package kettu;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringAppendingBenchmark {

  private final static int ITERATION_COUNT = 200000;

  private static void measureTime(final Supplier<String> supplier) {
    final Instant startTime = Instant.now();
    final String s = supplier.get();
    final Instant endTime = Instant.now();

    System.out.println("String length: " + s.length());
    System.out.println("Execution time: " + Duration.between(startTime, endTime).toMillis() + " ms");
    System.out.println();
  }

  static void concatExample() {
    measureTime(() -> {
      String s = "";
      for (int i = 0; i < ITERATION_COUNT; i++) {
        s += i;
      }
      return s;
    });
  }

  static void stringBuilderExample() {
    measureTime(() -> {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < ITERATION_COUNT; i++) {
        sb.append(i);
      }
      return sb.toString();
    });
  }

  static void stringBuilderInitialSizeExample() {
    measureTime(() -> {
      StringBuilder sb = new StringBuilder(1088890);
      for (int i = 0; i < ITERATION_COUNT; i++) {
        sb.append(i);
      }
      return sb.toString();
    });
  }

  static void streamExample() {
    measureTime(() -> {
      return IntStream.range(0, ITERATION_COUNT)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining());
    });
  }

}
