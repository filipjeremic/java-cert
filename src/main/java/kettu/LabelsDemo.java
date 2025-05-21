package kettu;

public class LabelsDemo {

  public static void runExamples() {
    loopExample();
    labeledBlockExample();
  }

  private static void loopExample() {
    outer: for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 1) {
          continue outer;
        }
        System.out.printf("i=%d   j=%d%n", i, j);
      }
    }
  }

  private static void labeledBlockExample() {
    skip: {
      final double x = Math.random();
      if (x < 0.5) {
        System.out.println("x is small");
        break skip;
      }
      System.out.printf("x=%f%n", x);
    }
  }

}
