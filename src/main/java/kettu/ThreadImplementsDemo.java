package kettu;

public class ThreadImplementsDemo implements Runnable {

  @Override
  public void run() {
    System.out.println("I'm runnable");
  }

}
