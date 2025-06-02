package kettu;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

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

  public static void futureExample() {
    try (final ExecutorService executor = Executors.newFixedThreadPool(2)) {
      final Callable<Integer> task = () -> {
        return 42;
      };

      final Future<Integer> future = executor.submit(task);

      final Integer result = future.get();
      System.out.println("Result: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  public static void completionServiceExample() {
    final Callable<Integer> randomIntTask = () -> {
      final int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
      System.out.println("ThreadId: " + Thread.currentThread().threadId() + " --- value: " + randomInt);
      return randomInt;
    };

    try (final ExecutorService executor = Executors.newFixedThreadPool(5)) {
      final CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

      final int ITERATION_COUNT = 10;

      for (int i = 0; i < ITERATION_COUNT; i++) {
        completionService.submit(randomIntTask);
      }

      for (int i = 0; i < ITERATION_COUNT; i++) {
        final Future<Integer> future = completionService.take();
        System.out.println(future.get());
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

}
