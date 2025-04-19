package kettu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapDemo {

  public static void runExamples() {
    example1();
    example2();
  }

  private static void example1() {
    final List<List<String>> petLists = Arrays.asList(
        Arrays.asList("Siamese", "Munchkin", "Persian", "Ragamuffin"),
        Arrays.asList("Beagle", "Greyhound", "Vizsla", "Dachshund"),
        Arrays.asList("Budgie", "Cockatiel", "Lovebird"));

    final List<String> allPetsCaps = petLists.stream()
        .flatMap(list -> list.stream().map(String::toUpperCase)).toList();

    System.out.println(allPetsCaps);
  }

  private static void example2() {
    final int[] arr1 = new int[] { 14, 5, 9, -36, 77, };
    final int[] arr2 = new int[] { 69, 0, -53, 28 };

    Stream.of(arr1, arr2)
        .flatMapToInt(IntStream::of)
        .max()
        .ifPresent(System.out::println);

    Stream.of(arr1, arr2)
        .flatMapToInt(IntStream::of)
        .min()
        .ifPresent(System.out::println);
  }

}
