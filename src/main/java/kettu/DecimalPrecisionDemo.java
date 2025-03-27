package kettu;

import java.math.BigDecimal;

public class DecimalPrecisionDemo {

  public static void precisionErrorExample() {

    final double x = 0.012;
    final double y = 3 * x;

    System.out.println(y);

  }

  public static void bigDecimalExample() {

    final BigDecimal x = new BigDecimal("0.12");
    final BigDecimal y = x.multiply(new BigDecimal(3));

    System.out.println(y);

  }

}
