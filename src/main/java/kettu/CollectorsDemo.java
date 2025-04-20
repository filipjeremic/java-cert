package kettu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

  public static void runExample() {
    final List<String> names = Arrays.asList("Tom", "John", "Tony", "Jane", "Bill", "Robert", "Ann");
    final Map<Integer, List<String>> groupedNames = names.stream().collect(Collectors.groupingBy(String::length));
    System.out.println("Grouped Names: " + groupedNames);
  }
}
