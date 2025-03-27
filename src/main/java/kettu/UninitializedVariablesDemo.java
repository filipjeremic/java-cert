package kettu;

public class UninitializedVariablesDemo {

  static boolean static_boolean;
  static int static_int;
  static double static_double;

  static Boolean static_Boolean;
  static Integer static_Integer;
  static Double static_Double;
  static String static_String;

  boolean instance_boolean;
  int instance_int;
  double instance_double;

  Boolean instance_Boolean;
  Integer instance_Integer;
  Double instance_Double;
  String instance_String;

  @SuppressWarnings("unused")
  public static void examples() {

    System.out.println("static_boolean: " + static_boolean);
    System.out.println("static_int: " + static_int);
    System.out.println("static_double: " + static_double);
    System.out.println();

    System.out.println("static_Boolean: " + static_Boolean);
    System.out.println("static_Integer: " + static_Integer);
    System.out.println("static_Double: " + static_Double);
    System.out.println("static_String: " + static_String);
    System.out.println();

    UninitializedVariablesDemo uv = new UninitializedVariablesDemo();

    System.out.println("instance_boolean: " + uv.instance_boolean);
    System.out.println("instance_int: " + uv.instance_int);
    System.out.println("instance_double: " + uv.instance_double);
    System.out.println();

    System.out.println("instance_Boolean: " + uv.instance_Boolean);
    System.out.println("instance_Integer: " + uv.instance_Integer);
    System.out.println("instance_Double: " + uv.instance_Double);
    System.out.println("instance_String: " + uv.instance_String);
    System.out.println();

    boolean local_boolean;
    int local_int;
    double local_double;

    Boolean local_Boolean;
    Integer local_Integer;
    Double local_Double;
    String local_String;

    // System.out.println("local_boolean: " + local_boolean);
    // System.out.println("local_int: " + local_int);
    // System.out.println("local_double: " + local_double);

    // System.out.println("local_Boolean: " + local_Boolean);
    // System.out.println("local_Integer: " + local_Integer);
    // System.out.println("local_Double: " + local_Double);
    // System.out.println("local_String: " + local_String);

  }

}
