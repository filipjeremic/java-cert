package kettu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSynchronization {

  private int value = 5;

  private int getValue() {
    return value;
  }

  private void addValue(final int x) {
    value += x;
  }

  private void withoutSynchronization() {
    final int currentValue = getValue();
    System.out.println("Start value: " + currentValue);

    if (currentValue < 10) {
      addValue(10);
      System.out.println("End value: " + getValue());
    } else {
      System.out.println("Value already too large");
    }
  }

  public void testSequential() {
    withoutSynchronization();
    withoutSynchronization();
  }

  public void testWithoutSynchronization() {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    executorService.submit(() -> withoutSynchronization());
    executorService.submit(() -> withoutSynchronization());

    executorService.shutdown();
  }

  private synchronized void withSynchronization() {
    final int currentValue = getValue();
    System.out.println("Start value: " + currentValue);

    if (currentValue < 10) {
      addValue(10);
      System.out.println("End value: " + getValue());
    } else {
      System.out.println("Value already too large");
    }
  }

  public void testWithSynchronization() {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    executorService.submit(() -> withSynchronization());
    executorService.submit(() -> withSynchronization());

    executorService.shutdown();
  }

}
