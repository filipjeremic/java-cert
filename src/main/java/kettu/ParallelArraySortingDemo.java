package kettu;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class ParallelArraySortingDemo {

  private static void print15(final int[] arr) {
    final StringBuilder sb = new StringBuilder();
    Arrays.stream(arr).limit(15).forEach(i -> sb.append(i).append(' '));
    System.out.println(sb);
  }

  private static void sort(final int[] arr, final Consumer<int[]> sortMethod) {
    final Instant start = Instant.now();
    sortMethod.accept(arr);
    final Instant end = Instant.now();
    final Duration duration = Duration.between(start, end);
    print15(arr);
    System.out.printf("Duration: %d ms%n", duration.toMillis());
  }

  public static void runExample() {
    final int MAX = 25000000;
    final int[] arr = new Random().ints(MAX, 1, MAX).toArray();

    sort(arr.clone(), Arrays::sort);
    sort(arr.clone(), Arrays::parallelSort);
  }

}
