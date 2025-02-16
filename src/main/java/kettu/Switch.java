package kettu;

import java.util.Arrays;

enum Birds {
  EAGLE, SPARROW, PARROT, OSTRICH, PENGUIN
}

public class Switch {

  public static void primitiveDataTypesExample() {
    final int x = 2;
    switch (x) {
      case 1:
        System.out.println("one");
        break;
      case 2:
        System.out.println("two");
        break;
      case 3:
        System.out.println("three");
        break;
      default:
        System.out.println("other");
        break;
    }

    final char c = 'L';
    switch (c) {
      case 'K':
        System.out.println("kilo");
        break;
      case 'L':
        System.out.println("lima");
        break;
      case 'M':
        System.out.println("mike");
        break;
      default:
        System.out.println("n/a");
        break;
    }
  }

  public static void wrapperClassExample() {
    Arrays.asList(Byte.valueOf((byte) 3), Byte.valueOf((byte) 4), null).forEach(b -> {
      switch (b) {
        case 4:
          System.out.println("four");
          break;
        case 5:
          System.out.println("five");
          break;
        case null:
          System.out.println("null");
          break;
        default:
          System.out.println("other");
          break;
      }
    });
  }

  public static void stringExample() {
    Arrays.asList("apple", "banana", "cherry", null).forEach((final String fruit) -> {
      switch (fruit) {
        case "apple":
          System.out.println("homegrown");
          break;
        case "banana":
          System.out.println("imported");
          break;
        case null, default:
          System.out.println("unknown");
          break;
      }
    });
  }

  public static void enumExample() {
    Arrays.asList(Birds.EAGLE, Birds.SPARROW, Birds.PARROT, Birds.OSTRICH, Birds.PENGUIN, null).forEach(bird -> {
      switch (bird) {
        case EAGLE, SPARROW, PARROT:
          System.out.println("flying");
          break;
        case OSTRICH, PENGUIN:
          System.out.println("flightless");
          break;
        case null, default:
          System.out.println("unknown");
          break;
      }
    });
  }

}
