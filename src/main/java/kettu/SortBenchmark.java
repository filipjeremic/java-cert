package kettu;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortBenchmark {

  private static int[] generateRandomIntArray(final long streamSize, final int randomNumberOrigin,
      final int randomNumberBound) {
    final Random random = new Random();
    return random.ints(streamSize, randomNumberOrigin, randomNumberBound).toArray();
  }

  private static void timeFunction(final Runnable f) {
    final long startTime = System.nanoTime();
    f.run();
    final long endTime = System.nanoTime();
    final long duration = endTime - startTime;
    System.out.println("Duration: " + (duration / 1_000_000_000d) + " s");
  }

  public static void timeAll() {
    for (int i = 0; i < 5; i++) {
      final int[] arr = generateRandomIntArray(15000000, 0, 10000);

      final int[] arr1 = arr.clone();
      timeFunction(() -> {
        Arrays.sort(arr1);
      });

      timeFunction(() -> {
        IntStream.of(arr).sorted().toArray();
      });

      final int[] arr2 = arr.clone();
      timeFunction(() -> {
        Arrays.parallelSort(arr2);
      });

      System.out.println();
    }
  }
}
