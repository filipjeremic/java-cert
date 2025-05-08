package kettu;

public class OperatorDemo {

    public static void example1() {
        int x = 5;
        System.out.println(++x);
        System.out.println(x++);

        // these won't compile because ++x and x++ aren't l-values
        // System.out.println(++x++);
        // ++x = 10;
        // x++ = 10;
    }

    @SuppressWarnings("unused")
    public static void example2() {
        int i1 = 0;
        int i2 = 0;
        boolean b = true;
        // (b ? a1 : a2) = 5; doesn't compile, but would work in C++
    }

}
