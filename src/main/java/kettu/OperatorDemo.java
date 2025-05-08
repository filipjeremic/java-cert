package kettu;

public class OperatorDemo {

    public static void lValueExample() {
        int x = 5;
        System.out.println(++x);
        System.out.println(x++);

        // these won't compile because ++x and x++ aren't l-values
        // System.out.println(++x++);
        // ++x = 10;
        // x++ = 10;
    }

    @SuppressWarnings("unused")
    public static void ternaryLValueExample() {
        int i1 = 0;
        int i2 = 0;
        boolean b = true;
        // (b ? a1 : a2) = 5; doesn't compile, but would work in C++
    }

    public static void sideEffectsExample() {
        int x = 1;
        try {
            int y = 2 / --x;
            System.out.println(y);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void remainderExample() {
        // the sign of the right operand is ignored
        // the result is always the same sign as the left operand
        System.out.println(5 % 3);
        System.out.println(-5 % 3);
        System.out.println(5 % -3);
        System.out.println(-5 % -3);
    }

    @SuppressWarnings("unused")
    public static void assignmentExample() {
        int[] ia1 = { 0, 1, 2, 3 };
        int[] ia2 = { 5, 6, 7, 8 };
        int[] ia = ia1;
        int x = 0;
        System.out.println((ia = ia2)[x = 3]); // prints 8
    }

}
