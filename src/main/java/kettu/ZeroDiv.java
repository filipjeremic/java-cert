package kettu;

public class ZeroDiv {

  public static void runExamples() {

    try {
      final int notUseful = 0 / 0;
      System.out.println(notUseful);
    } catch (ArithmeticException e) {
      System.out.println("This throws and ArithmeticException");
    }

    final double infinity = 1.0 / 0.0;
    System.out.println("This produces " + infinity);

    final double infinityAsWell = -1.0 / -0.0;
    System.out.println("This produces " + infinityAsWell);

    final double negativeInfinity = -1.0 / 0.0;
    System.out.println("This produces " + negativeInfinity);

    final double negativeInfinityAsWell = 1.0 / -0.0;
    System.out.println("This produces " + negativeInfinityAsWell);

    final double nan = 0 / 0.0;
    System.out.println("This produces " + nan);

    final double nanAsWell = -0 / 0.0;
    System.out.println("This produces " + nanAsWell);

    final double anotherNan = 0 / -0.0;
    System.out.println("This produces " + anotherNan);

  }

}
