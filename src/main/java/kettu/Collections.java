package kettu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Collections {

  public static void linkedLists() {

    System.out.println("----- linkedLists -----");

    LinkedList<String> list = new LinkedList<>();
    list.add("item 1");
    list.add("item 2");
    list.add("item 3");

    System.out.println(list);

    System.out.println(list.getFirst());
    System.out.println(list.getLast());

    System.out.println(list.poll());
    System.out.println(list);

    System.out.println(list.pop());
    System.out.println(list);

    System.out.println(list.poll());
    System.out.println(list.poll());

    try {
      System.out.println(list.pop());
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }

    System.out.println();

  }

  public static void hashMaps() {

    System.out.println("----- hashMaps -----");

    HashMap<String, Integer> basket = new HashMap<>();

    basket.put("bread", 1);
    System.out.println(basket);

    basket.put("bread", 2);
    System.out.println(basket);

    System.out.println(basket.containsKey("bread"));

    basket.merge("bread", 1, Integer::sum);
    basket.merge("milk", 1, Integer::sum);
    System.out.println(basket);

    System.out.println();

  }

  public static void unorderedHashMaps() {

    System.out.println("----- unorderedHashMaps -----");

    HashMap<String, Integer> basket = new HashMap<>();

    basket.put("bread", 4);
    basket.put("milk", 7);
    basket.put("eggs", 12);

    basket.forEach((key, value) -> System.out.println(key + ": " + value));

    System.out.println();

  }

  public static void orderedHashMaps() {

    System.out.println("----- orderedHashMaps -----");

    LinkedHashMap<String, Integer> basket = new LinkedHashMap<>();

    basket.put("bread", 4);
    basket.put("milk", 7);
    basket.put("eggs", 12);

    basket.forEach((key, value) -> System.out.println(key + ": " + value));

    System.out.println();

  }

}
