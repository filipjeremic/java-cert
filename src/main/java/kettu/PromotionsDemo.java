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

  @SuppressWarnings("unused")
  public static void safeAssignmentsExample() {
    final long l = 4;
    // these fail because long is larger than int, even though the value would fit
    // byte b = l;
    // final int i = l;

    // initialization works if the value fits the target size
    final byte b0 = 127;
    // final byte b1 = 128;

    final int fi = 80;
    byte b1 = fi; // work because the compiler knows the value is int and will fit

    int i = 80;
    // byte b2 = i; i is not a constant expression
  }

  @SuppressWarnings("unused")
  public static void ternaryOperatorExample() {
    final byte fb = 1;
    byte b = 1;
    final short fs = 2;
    short s = 2;
    final int fi = 3;
    int i = 3;
    final int fiBig = 1_000_000;
    int iBig = 1_000_000;
    final long fl = 4;
    long l = 4;
    final float ff = 5.0f;
    float f = 5.0f;
    final double fd = 6.0;
    double d = 6.0;

    final boolean boolTrue = true;
    final boolean boolFalse = false;

    System.out.println(((Object) (boolTrue ? fb : fs)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : fs)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : s)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : s)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fb : fi)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : fi)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : i)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : i)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fb : fiBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : fiBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : iBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : iBig)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fs : fi)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fs : fi)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? s : i)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? s : i)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fs : fiBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fs : fiBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? s : iBig)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? s : iBig)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fb : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : l)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : l)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fs : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fs : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? s : l)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? s : l)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fi : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fi : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? i : l)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? i : l)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fiBig : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fiBig : fl)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? iBig : l)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? iBig : l)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fb : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : f)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : f)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fs : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fs : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? s : f)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? s : f)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fi : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fi : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? i : f)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? i : f)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fiBig : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fiBig : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? iBig : f)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? iBig : f)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fl : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fl : ff)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? l : f)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? l : f)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fb : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fb : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? b : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? b : d)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fs : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fs : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? s : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? s : d)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fi : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fi : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? i : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? i : d)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fiBig : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fiBig : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? iBig : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? iBig : d)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? fl : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? fl : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? l : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? l : d)).getClass().getSimpleName());
    System.out.println();

    System.out.println(((Object) (boolTrue ? ff : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? ff : fd)).getClass().getSimpleName());
    System.out.println(((Object) (boolTrue ? f : d)).getClass().getSimpleName());
    System.out.println(((Object) (boolFalse ? f : d)).getClass().getSimpleName());
    System.out.println();

    final Boolean BoolTrue = true;
    final Boolean BoolFalse = false;
    final var primitiveBoolean1 = boolTrue ? boolTrue : boolFalse;
    final var primitiveBoolean2 = boolTrue ? boolTrue : BoolFalse;
    final var booleanWrapper1 = boolTrue ? BoolTrue : BoolFalse;

    final Integer Int1 = 1;
    final Integer Int2 = 2;
    final var integerWrapper1 = boolTrue ? Int1 : Int2;
    final var primitiveInt1 = boolTrue ? Int1 : 1;
    final Double Double1 = 1.0;
    final Double Double2 = 2.0;
    final var doubleWrapper1 = boolTrue ? Double1 : Double2;
    final var primitiveDouble1 = boolTrue ? Double1 : 1.0;
    final var primitiveDouble2 = boolTrue ? Double1 : Int1;

    class A {
    }
    class B extends A {
    }
    class C extends A {
    }

    final B br = new B();
    final C cr = new C();

    final var ar = boolTrue ? br : cr; // A

    final String str = "";
    final StringBuilder sb;
    final var ss = boolTrue ? str : sb; // Object & Serializable & Comparable<?> & CharSequence

    final var io = boolTrue ? i : new Object(); // Object
  }

}
