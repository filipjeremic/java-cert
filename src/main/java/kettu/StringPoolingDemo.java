package kettu;

public class StringPoolingDemo {

  public static void identityExamples() {
    String s1 = "Hello world";

    String s2 = "Hello world";
    System.out.println(s1 == s2); // same object in memory

    final String s3 = "Hello world";
    System.out.println(s1 == s3); // same object in memory

    String s4 = "Hello" + " world";
    System.out.println(s1 == s4); // same object in memory

    String s5 = "Hello";
    s5 += " world";
    System.out.println(s1 == s5); // dynamically created - different object in memory

    final String s6 = "Hello";
    String s7 = s6 + " world";
    System.out.println(s1 == s7); // same object in memory

    String s8 = new String("Hello world");
    System.out.println(s1 == s8); // dynamically created - different object in memory

    s8 = s8.intern();
    System.out.println(s1 == s8); // now it's the same object in memory
  }

}
