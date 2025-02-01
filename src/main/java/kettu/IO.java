package kettu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IO {

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

  public static void fileCreationExample() {

    Path path = Paths.get("test.txt");

    try {
      Files.createFile(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void listFilesExample() {

    try {
      Files.list(Paths.get(".")).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
