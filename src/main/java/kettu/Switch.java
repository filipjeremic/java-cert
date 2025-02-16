package kettu;

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

}
