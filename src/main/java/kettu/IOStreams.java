package kettu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class IOStreams {

  public static void bufferedReaderExample() {

    try (BufferedReader reader = new BufferedReader(new FileReader("doesn't exist"))) {
      String firstLine = reader.readLine();
      System.out.println(firstLine);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void bufferedReaderAndStreamsExample() {

    try (BufferedReader reader = new BufferedReader(new FileReader("doesn't exist"))) {
      Stream<String> lines = reader.lines();
      lines.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
