package kettu;

interface One {
  default void printName() {
    System.out.println("One");
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
}
