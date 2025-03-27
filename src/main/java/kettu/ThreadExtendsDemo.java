package kettu;

public class ThreadExtendsDemo extends Thread {

  @Override
  public void run() {
    System.out.println("Hi from " + this.getName());
  }

}
