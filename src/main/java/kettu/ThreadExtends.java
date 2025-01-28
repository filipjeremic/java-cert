package kettu;

public class ThreadExtends extends Thread {

  @Override
  public void run() {
    System.out.println("Hi from " + this.getName());
  }

}
