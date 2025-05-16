package kettu;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class DateTimeDemo {

  public static void runExamples() {
    localDateExample();
    localTimeExample();
    localDateTimeExample();
    zonedDateTimeExample();
    zonedDateTimeExample2();
    dateTimeManipulationExample();
    periodExample();
    normalizedPeriodExample();
    durationExample();
    durationExample2();
    supportedFieldsExample();
  }

  private static void localDateExample() {
    final LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
    System.out.printf("%d == %d%n", localDate.getYear(), localDate.get(ChronoField.YEAR));
    System.out.printf("%s is month number %d%n", localDate.getMonth(), localDate.get(ChronoField.MONTH_OF_YEAR));
    System.out.printf("%s is day number %d in a week%n", localDate.getDayOfWeek(),
        localDate.get(ChronoField.DAY_OF_WEEK));

    final LocalDate parsedLocalDate = LocalDate.parse("2024-07-26");
    System.out.println(parsedLocalDate);

    System.out.println(parsedLocalDate.with(ChronoField.MONTH_OF_YEAR, 2));
  }

  private static void localTimeExample() {
    final LocalTime localTime = LocalTime.now();
    System.out.println(localTime);
  }

  private static void localDateTimeExample() {
    final LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);

    final var localDate = LocalDate.from(localDateTime);
    System.out.println(localDate);

    final var localTime = LocalTime.from(localDateTime);
    System.out.println(localTime);

    final var localDateTime2 = localDate.atTime(15, 33, 59);
    System.out.println(localDateTime2);
  }

  private static void zonedDateTimeExample() {
    final ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);
  }

  private static void zonedDateTimeExample2() {
    final Instant instant = Instant.now();
    final ZonedDateTime zdtAntarcticaVostok = ZonedDateTime.ofInstant(instant, ZoneId.of("Antarctica/Vostok"));

    System.out.println(instant);
    System.out.println(zdtAntarcticaVostok);
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

  private static void normalizedPeriodExample() {
    final Period period = Period.of(2, 17, 500);
    System.out.println(period);
    System.out.println(period.normalized());
    // months can be normalized, but days can't
    // 12 months always make a year
    // months and years can differ in length
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

  private static void durationExample2() {
    final Duration duration1 = Duration.ofMinutes(30);
    final Duration duration2 = Duration.ofMinutes(270);
    System.out.println(duration1);
    System.out.println(duration2);
  }

  private static void supportedFieldsExample() {
    final LocalDate localDate = LocalDate.now();
    System.out.printf("%b %b%n", localDate.isSupported(ChronoField.MONTH_OF_YEAR),
        localDate.isSupported(ChronoField.HOUR_OF_DAY));

    final LocalTime localTime = LocalTime.now();
    System.out.printf("%b %b%n", localTime.isSupported(ChronoField.MONTH_OF_YEAR),
        localTime.isSupported(ChronoField.HOUR_OF_DAY));

    final LocalDateTime localDateTime = LocalDateTime.now();
    System.out.printf("%b %b%n", localDateTime.isSupported(ChronoField.MONTH_OF_YEAR),
        localDateTime.isSupported(ChronoField.HOUR_OF_DAY));
  }

}
