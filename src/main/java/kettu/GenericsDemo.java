package kettu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {

  @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
  public static void Unparameterized() {

    System.out.println("----- Unparameterized -----");

    // Unparameterized list - elements are of type Object
    List shapes = new ArrayList();
    shapes.add("Circle");

    // This works fine
    System.out.println(shapes.get(0));

    // This doesn't compile because get returns an Object
    // String circle = shapes.get(0);

    // We can use a cast
    String circle = (String) shapes.get(0);
    System.out.println(circle);

    // Instances of other types can be added
    shapes.add(new StringBuilder());
    System.out.println(shapes);

    // Nothing prevents casting to the wrong type
    // The code compiles, but an exception is thrown at runtime
    try {
      Integer wrong = (Integer) shapes.get(1);
    } catch (ClassCastException e) {
      System.out.println(e.getMessage());
    }

    System.out.println();

  }

  public static void Parameterized() {

    System.out.println("----- Parameterized -----");

    // Parameterized list - elements are of type String
    // The compiler infers the type on the right side from the left side
    List<String> shapes = new ArrayList<>();
    shapes.add("Circle");

    // Still works fine
    System.out.println(shapes.get(0));

    // This compiles and works as expected because get returns a String type now
    // Casting is not needed
    String circle = shapes.get(0);
    System.out.println(circle);

    // This no longer compiles - add expects a String now
    // shapes.add(new StringBuilder());

    shapes.add("Rectangle");
    String rectangle = shapes.get(1);
    System.out.println(rectangle);

    System.out.println();

  }

  private static <T> List<T> convertArrayToList(T[] array) {
    return Arrays.asList(array);
  }

  public static void Methods() {

    System.out.println("----- Methods -----");

    String[] animalsArray = { "dog", "cat", "fish", "bird" };
    Integer[] numbersArray = { 1, 3, 4, 6, 7, 9 };

    List<String> animalsList = convertArrayToList(animalsArray);
    System.out.println(Arrays.toString(animalsArray));
    System.out.println(animalsList);

    List<Integer> numbersList = convertArrayToList(numbersArray);
    System.out.println(Arrays.toString(numbersArray));
    System.out.println(numbersList);

    System.out.println();

  }

  private static <T extends Number> List<T> convertArrayToListBounded(T[] array) {
    return Arrays.asList(array);
  }

  @SuppressWarnings("unused")
  public static void Bounded() {

    System.out.println("----- Bounded -----");

    String[] animalsArray = { "dog", "cat", "fish", "bird" };
    Integer[] integersArray = { 1, 3, 4, 6, 7, 9 };
    Float[] floatsArray = { 1.3f, 2.4f, 3.6f, 6.7f, 7.1f, 9.32f };

    // No longer compiles
    // List<String> animalsList = convertArrayToListBounded(animalsArray);

    List<Integer> integersList = convertArrayToListBounded(integersArray);
    System.out.println(Arrays.toString(integersArray));
    System.out.println(integersList);

    List<Float> floatsList = convertArrayToListBounded(floatsArray);
    System.out.println(Arrays.toString(floatsArray));
    System.out.println(floatsList);

    System.out.println();

  }

}
