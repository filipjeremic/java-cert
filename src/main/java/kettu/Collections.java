package kettu;

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

}
