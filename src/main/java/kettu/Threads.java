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

}
