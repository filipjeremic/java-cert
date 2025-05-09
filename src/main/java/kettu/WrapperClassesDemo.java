package kettu;

public class WrapperClassesDemo {

  @SuppressWarnings("unused")
  public static void boxingExamples() {
    final Integer wi = 5; // automatic boxing
    final int i = wi; // automatic unboxing
    final long l = wi; // the compiler unwraps the value and does the promotion
    Object o = i; // creates an Integer object and assigns it to o

    // doesn't work because the compiler needs
    // to do two things - boxing and promoting
    // Long wl = 99;
  }

  public static void realNumbersSpecialCasesDemo() {
    final float floatPositiveInfinity = Float.valueOf("Infinity");
    System.out.println(floatPositiveInfinity);
    final float floatNegativeInfinity = Float.valueOf("-Infinity");
    System.out.println(floatNegativeInfinity);
    final float floatNaN = Float.valueOf("NaN");
    System.out.println(floatNaN);

    System.out.println();

    final Float FloatPositiveInfinity = Float.POSITIVE_INFINITY;
    System.out.println(FloatPositiveInfinity);
    final Float FloatNegativeInfinity = Float.NEGATIVE_INFINITY;
    System.out.println(FloatNegativeInfinity);
    final Float FloatNaN = Float.NaN;
    System.out.println(FloatNaN);

    System.out.println();

    final double doublePositiveInfinity = Double.valueOf("+Infinity");
    System.out.println(doublePositiveInfinity);
    final double doubleNegativeInfinity = Double.valueOf("-Infinity");
    System.out.println(doubleNegativeInfinity);
    final double doubleNaN = Double.valueOf("NaN");
    System.out.println(doubleNaN);

    System.out.println();

    final Double DoublePositiveInfinity = Double.POSITIVE_INFINITY;
    System.out.println(DoublePositiveInfinity);
    final Double DoubleNegativeInfinity = Double.NEGATIVE_INFINITY;
    System.out.println(DoubleNegativeInfinity);
    final Double DoubleNaN = Double.NaN;
    System.out.println(DoubleNaN);
  }

}
