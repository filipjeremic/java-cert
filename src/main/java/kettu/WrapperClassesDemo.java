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

}
