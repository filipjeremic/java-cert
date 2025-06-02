package kettu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {

  public static void threadExtendsExample() {
    ThreadExtendsDemo t1 = new ThreadExtendsDemo();
    ThreadExtendsDemo t2 = new ThreadExtendsDemo();

    t1.setName("t1");
    t2.setName("t2");

    t1.start();
    t2.start();
  }

  public static void threadImplementsExample() {
    Thread t1 = new Thread(new ThreadImplementsDemo());
    Thread t2 = new Thread(() -> System.out.println("I'm a runnable lambda"));

    t1.start();
    t2.start();
  }

  public static void executorServiceExample() {
    System.out.println("Main threadId: " + Thread.currentThread().threadId());

    final ExecutorService executorService = Executors.newFixedThreadPool(3);

    executorService.submit(new ThreadImplementsDemo());
    executorService.submit(() -> System.out.println("Lambda threadId: " + Thread.currentThread().threadId()));

    final Runnable task = () -> {
      System.out.println("Task threadId: " + Thread.currentThread().threadId());
    };

    for (int i = 0; i < 3; i++) {
      executorService.execute(task);
    }

    executorService.shutdown();
  }

}
