package kettu;

public class MathAPIDemo {

    public static void runExamples() {
        minExample();
        maxExample();
        roundExample();
        ceilExample();
        floorExample();
        randomExample();
    }

    private static void minExample() {
        System.out.println(Math.min(3, 4));
    }

    private static void maxExample() {
        System.out.println(Math.max(4.71, 7.89));
    }

    private static void roundExample() {
        System.out.println(Math.round(3.3f));
        System.out.println(Math.round(3.5f));
        System.out.println(Math.round(3.6f));

        System.out.println(Math.round(6.4));
        System.out.println(Math.round(6.5));
        System.out.println(Math.round(6.99));
    }

    private static void ceilExample() {
        System.out.println(Math.ceil(3.14));
        System.out.println(Math.ceil(8));
    }

    private static void floorExample() {
        System.out.println(Math.floor(3.14));
        System.out.println(Math.floor(7.99));
        System.out.println(Math.floor(8));
    }

    private static void randomExample() {
        System.out.println(Math.random());
    }

}
