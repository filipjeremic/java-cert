package kettu;

public class RecordPatternsDemo {

  public static void runExamples() {
    flexibilityExample();
    typeBasedPatternExample();
  }

  record Point(int x, int y) {
  }

  enum Color {
    RED, GREEN, BLUE
  }

  record ColoredPoint(Point p, Color c) {
  }

  record Rectangle(ColoredPoint first, ColoredPoint second) {
  }

  private static void flexibilityExample() {

    final Object r = new Rectangle(new ColoredPoint(new Point(3, 4), Color.RED),
        new ColoredPoint(new Point(5, 6), Color.BLUE));

    if (r instanceof Rectangle(ColoredPoint(Point p, var c), var coloredPoint)) {
      System.out.println("Color 1: " + c);
      System.out.println("Color 2: " + coloredPoint.c);
    }

  }

  record TestRecord(Object obj) {
  }

  private static void printTypeBasedPattern(final TestRecord testRecord) {
    switch (testRecord) {
      case TestRecord(String s) -> System.out.println("String: " + s);
      case TestRecord(Object o) -> System.out.println("Object: " + o);
    }
  }

  private static void typeBasedPatternExample() {
    printTypeBasedPattern(new TestRecord(new Object()));
    printTypeBasedPattern(new TestRecord("abc"));
  }

}
