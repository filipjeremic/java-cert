package kettu;

public class Threads {

  public static void testThreadExtends() {
    ThreadExtends t1 = new ThreadExtends();
    ThreadExtends t2 = new ThreadExtends();

    t1.setName("t1");
    t2.setName("t2");

    t1.start();
    t2.start();
  }

  public static void testThreadImplements() {
    Thread t1 = new Thread(new ThreadImplements());
    Thread t2 = new Thread(() -> System.out.println("I'm a runnable lambda"));

    t1.start();
    t2.start();
  }

}
