package kettu;

public class PromotionsDemo {

  public static void arithmeticTypesExample() {
    final byte b = 1;
    final short s = 2;
    final int i = 3;
    final long l = 4;
    final float f = 5.0f;
    final double d = 6.0;

    // Integer
    System.out.println(((Object) (b + s)).getClass().getSimpleName());
    System.out.println(((Object) (b + i)).getClass().getSimpleName());
    System.out.println(((Object) (s + i)).getClass().getSimpleName());
    System.out.println();

    // Long
    System.out.println(((Object) (b + l)).getClass().getSimpleName());
    System.out.println(((Object) (s + l)).getClass().getSimpleName());
    System.out.println(((Object) (i + l)).getClass().getSimpleName());
    System.out.println();

    // Float
    System.out.println(((Object) (b + f)).getClass().getSimpleName());
    System.out.println(((Object) (s + f)).getClass().getSimpleName());
    System.out.println(((Object) (i + f)).getClass().getSimpleName());
    System.out.println(((Object) (l + f)).getClass().getSimpleName());
    System.out.println();

    // Double
    System.out.println(((Object) (b + d)).getClass().getSimpleName());
    System.out.println(((Object) (s + d)).getClass().getSimpleName());
    System.out.println(((Object) (i + d)).getClass().getSimpleName());
    System.out.println(((Object) (l + d)).getClass().getSimpleName());
    System.out.println(((Object) (f + d)).getClass().getSimpleName());
  }

}
