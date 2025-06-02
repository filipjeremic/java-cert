package kettu;

public class ThreadImplementsDemo implements Runnable {

  @Override
  public void run() {
    System.out.println("ThreadImplementsDemo threadId: " + Thread.currentThread().threadId());
  }

}
