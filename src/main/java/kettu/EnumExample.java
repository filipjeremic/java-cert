package kettu;

import java.util.EnumSet;

enum Color {
  WHITE,
  RED(0xFF0000),
  GREEN(0x00FF00),
  BLUE(0x0000FF),
  BLACK(0x000000);

  final int hexCode;

  private Color() {
    this(0xFFFFFF);
  }

  private Color(int hexCode) {
    this.hexCode = hexCode;
    System.out.println("Constructing: " + this.toString() + ", hex: #" + String.format("%06X", hexCode));
  }

  public void print() {
    System.out.println("I am the color " + this + ", hex: #" + String.format("%06X", hexCode));
  }
}

public class EnumExample {
  public static void run() {
    final EnumSet<Color> colors = EnumSet.range(Color.WHITE, Color.BLACK);
    colors.forEach(System.out::println);
    colors.forEach(Color::print);
  }
}
