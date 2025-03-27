package kettu;

import java.util.Arrays;
import java.util.List;

public class ComparableInterfaceDemo {

  private static class TestClass implements Comparable<TestClass> {

    private final int value;

    TestClass(final int value) {
      this.value = value;
    }

    @Override
    public int compareTo(TestClass tc) {
      return value - tc.value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  public static void run() {
    List<TestClass> list = Arrays.asList(new TestClass(12), new TestClass(7), new TestClass(25), new TestClass(2),
        new TestClass(16));
    System.out.println(list);
    java.util.Collections.sort(list);
    System.out.println(list);
  }
}
