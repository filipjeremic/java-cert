package kettu;

interface One {

  default void printName() {
    System.out.println("One");
  }

  static void staticMethod() {
    System.out.println("Interface One static method");
  }

}

interface Two {
  default void printName() {
    System.out.println("Two");
  }
}

public class InterfacesDemo implements One, Two {

  @Override
  public void printName() {
    One.super.printName();
    Two.super.printName();
  }

  public static void test() {
    One.staticMethod();
  }

}
