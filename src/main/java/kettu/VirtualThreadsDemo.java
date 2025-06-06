package kettu;

import java.util.concurrent.Executors;

public class VirtualThreadsDemo {

  public static void runExamples() {
    virtualThreadPerTaskExecutorExample();
  }

  private static void virtualThreadPerTaskExecutorExample() {
    try (final var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 5; i++) {
        executor.execute(() -> System.out.println("ThreadId: " + Thread.currentThread().threadId()
            + " --- Is virtual thread? " + Thread.currentThread().isVirtual()));
      }
    }
  }

}
