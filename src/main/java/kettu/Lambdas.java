package kettu;

public class Lambdas {

  public static void functionalInterfacesTest() {

    FunctionalInterfaces f = () -> System.out.println("My lambda");
    f.printMessage();

  }

}
