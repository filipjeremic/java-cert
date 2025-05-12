package kettu;

public class TextBlockDemo {

  public static void example() {
    String multilineText = """
        hi there
        here's a line
        here's another line""";
    System.out.println(multilineText);

    System.out.println("---");

    var s = """
        x\r\n
        y""";
    System.out.println(s.charAt(1));
  }

}
