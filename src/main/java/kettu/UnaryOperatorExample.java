package kettu;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

  public static void run() {
    final List<String> list = Arrays.asList("one", "two", "three");
    System.out.println(list);

    final UnaryOperator<String> capitalize = s -> s.toUpperCase();
    list.replaceAll(capitalize);

    System.out.println(list);
  }
}
