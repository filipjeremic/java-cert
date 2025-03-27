package kettu;

public class StringImmutabilityDemo {

  public static void example1() {

    String s0 = "Hello";
    String s1 = s0.replace('l', 'L');

    System.out.println(s0);
    System.out.println(s1);

  }

  public static void example2() {

    char[] charArray = { 'H', 'e', 'l', 'l', 'o' };
    String s = new String(charArray);

    System.out.println(charArray);
    System.out.println(s);

    charArray[2] = 'L';
    charArray[3] = 'L';

    System.out.println(charArray);
    System.out.println(s);

  }

}
