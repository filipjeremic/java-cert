package kettu;

public class LambdasDemo {

  public static void functionalInterfacesDemo() {

    FunctionalInterfacesDemo f = () -> System.out.println("My lambda");
    f.printMessage();

  }

}
