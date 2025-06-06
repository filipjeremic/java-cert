package kettu;

public class RecordPatternsDemo {

  public static void runExamples() {
    flexibilityExample();
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

}
