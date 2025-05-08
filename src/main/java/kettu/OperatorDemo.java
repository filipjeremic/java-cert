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

}
