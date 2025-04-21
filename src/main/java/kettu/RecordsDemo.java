package kettu;

record MyNumber(int integerPart, int decimalPart) {

  boolean isWholeNumber() {
    return decimalPart == 0;
  }

  @Override
  public String toString() {
    return String.valueOf(integerPart) + (decimalPart != 0 ? "." + decimalPart : "");
  }

  static MyNumber floor(final MyNumber n) {
    return new MyNumber(n.integerPart, 0);
  }

}

public class RecordsDemo {

  static void runExamples() {
    final MyNumber wholeNumber1 = new MyNumber(3, 0);
    final MyNumber wholeNumber2 = MyNumber.floor(wholeNumber1);
    final MyNumber decimalNumber = new MyNumber(3, 14);

    System.out.printf("%s %x%n", wholeNumber1, wholeNumber1.hashCode());
    System.out.printf("%s %x%n", wholeNumber2, wholeNumber2.hashCode());
    System.out.printf("%b %b%n", wholeNumber1 == wholeNumber2, wholeNumber1.equals(wholeNumber2));
    System.out.println(decimalNumber);
  }

}
