package kettu;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;

public class DateTimeDemo {

  public static void runExamples() {
    localDateExample();
    localTimeExample();
    localDateTimeExample();
    zonedDateTimeExample();
    dateTimeManipulationExample();
    periodExample();
    durationExample();
  }

  private static void localDateExample() {
    final LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
  }

  private static void localTimeExample() {
    final LocalTime localTime = LocalTime.now();
    System.out.println(localTime);
  }

  private static void localDateTimeExample() {
    final LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
  }

  private static void zonedDateTimeExample() {
    final ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);
  }

  private static void dateTimeManipulationExample() {
    final LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
    final LocalDateTime localDateTimePlus30Days = localDateTime.plusDays(30);
    System.out.println(localDateTimePlus30Days);
  }

  private static void periodExample() {
    final LocalDate firstMoonLandingDate = LocalDate.of(1969, 7, 20);
    final LocalDate currentDate = LocalDate.now();

    final Period p = Period.between(firstMoonLandingDate, currentDate);

    System.out.printf("%d years, %d months, and %d days have passed since the first moon landing.%n", p.getYears(),
        p.getMonths(), p.getDays());
  }

  private static void durationExample() {
    final Instant start = Instant.now();
    try {
      Thread.sleep(487);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    final Instant end = Instant.now();
    final Duration duration = Duration.between(start, end);
    System.out.printf("Duration: %d milliseconds%n", duration.toMillis());
  }

}
