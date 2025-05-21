package kettu;

public class UnreachableCodeDemo {

  public static void runExamples() {
    whileExample();
    ifExample();
  }

  private static void whileExample() {
    // The compiler views this as dead code
    // final int x = 10;
    // while (x > 20) {
    // System.out.println("This is unreachable and won't compile");
    // }
  }

  @SuppressWarnings("unused")
  private static void ifExample() {
    // The compiler views this as conditional compilation
    if (true) {
      System.out.println("This is always printed");
    } else {
      System.out.println("This is unreachable, but does compile");
    }
  }

}
