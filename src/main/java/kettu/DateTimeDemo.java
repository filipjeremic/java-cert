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
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DateTimeDemo {

  public static void runExamples() {
    localDateExample();
    localTimeExample();
    localDateTimeExample();
    zonedDateTimeExample();
    zonedDateTimeExample2();
    zoneIdExample();
    zoneTransitionsExample();
    dateTimeManipulationExample();
    periodExample();
    normalizedPeriodExample();
    addingPeriodsExample();
    durationExample();
    durationExample2();
    supportedFieldsExample();
    adjustIntoExample();
    isLeapYearExample();
    timeZonesExample();
    instantAndPeriodExamples();
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

    final LocalDate localDateOf = LocalDate.of(2099, 7, 5);
    System.out.println(localDateOf);
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

  private static void zoneIdExample() {
    // ZoneId.getAvailableZoneIds().forEach(System.out::println);
    final var zoneId = ZoneId.of("Europe/Paris");
    System.out.println(zoneId);
  }

  private static void zoneTransitionsExample() {
    final var zoneId = ZoneId.of("Europe/Berlin");
    // zoneId.getRules().getTransitions().forEach(System.out::println);
    System.out.println(zoneId.getRules().nextTransition(Instant.now()));
    System.out.println(zoneId.getRules().previousTransition(Instant.now()));

    final var zonedDateTime = ZonedDateTime.parse("2025-03-29T00:00:00+01:00[Europe/Berlin]");
    System.out.println(zonedDateTime);
    System.out.println(zonedDateTime.plusHours(24));
    System.out.println(zonedDateTime.plusHours(48));
    System.out.println(zonedDateTime.plusHours(72));
    System.out.println(zonedDateTime.plusDays(1));
    System.out.println(zonedDateTime.plusDays(2));
    System.out.println(zonedDateTime.plusDays(3));
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

  public static void addingPeriodsExample() {
    final LocalDate feb15 = LocalDate.of(2025, 2, 15);
    System.out.println(feb15);

    final Period thirtyDaysPeriod = Period.ofDays(30);
    System.out.println(feb15.plus(thirtyDaysPeriod));

    final Period oneMonthPeriod = Period.ofMonths(1);
    System.out.println(feb15.plus(oneMonthPeriod));
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

  private static void adjustIntoExample() {
    final LocalDate localDate = LocalDate.of(2050, 10, 10);
    final LocalDateTime localDateTime = LocalDateTime.now();
    final Temporal adjustedLocalDateTime = localDate.adjustInto(localDateTime);
    System.out.println(adjustedLocalDateTime);
  }

  private static void isLeapYearExample() {
    final LocalDate localDate = LocalDate.now();
    System.out.printf("Year %d is %sa leap year%n", localDate.getYear(), localDate.isLeapYear() ? "" : "not ");
  }

  private static void timeZonesExample() {
    final var localDate = LocalDate.of(2000, 1, 1);
    final var localTime = LocalTime.of(14, 12);
    final var localDateTime = LocalDateTime.of(localDate, localTime);
    final var localDateTime2 = LocalDateTime.from(LocalDate.of(2025, 5, 17).adjustInto(localDateTime));
    System.out.println(localDateTime2);

    final var zonedDateTime = ZonedDateTime.of(localDateTime2, ZoneId.of("America/New_York"));
    System.out.println(zonedDateTime);

    final var instant = zonedDateTime.toInstant();
    System.out.println(instant);

    final var zonedDateTime2 = ZonedDateTime.ofInstant(instant, ZoneId.of("Australia/Queensland"));
    System.out.println(zonedDateTime2);

    final var takeoffTimeMontreal = ZonedDateTime.of(2025, 3, 22, 21, 58, 0, 0, ZoneId.of("America/Montreal"));
    final var landingTimeMontreal = takeoffTimeMontreal.plusHours(6).plusMinutes(20);
    final var landingTimeLisbon = landingTimeMontreal.withZoneSameInstant(ZoneId.of("Europe/Lisbon"));
    System.out.println(takeoffTimeMontreal);
    System.out.println(landingTimeMontreal);
    System.out.println(landingTimeLisbon);
  }

  private static void instantAndPeriodExamples() {
    final Period periodOneYear = Period.ofYears(1);
    final Period periodOneMonth = Period.ofMonths(1);

    final ZonedDateTime zdt_2020_2_1 = ZonedDateTime.of(2020, 2, 1, 12, 15, 30, 0, ZoneId.of("GMT"));

    final ZonedDateTime zdt_2021_2_1 = zdt_2020_2_1.plus(periodOneYear);
    final ZonedDateTime zdt_2020_3_1 = zdt_2020_2_1.plus(periodOneMonth);
    final ZonedDateTime zdt_2021_3_1 = zdt_2021_2_1.plus(periodOneMonth);

    final Instant instant_2020_2_1 = zdt_2020_2_1.toInstant();
    final Instant instant_2021_2_1 = zdt_2021_2_1.toInstant();

    System.out.println(instant_2020_2_1.until(zdt_2020_3_1, ChronoUnit.DAYS)); // leap year
    System.out.println(instant_2021_2_1.until(zdt_2021_3_1, ChronoUnit.DAYS)); // not a leap year
    System.out.println(instant_2020_2_1.until(zdt_2021_2_1, ChronoUnit.DAYS)); // leap year

    System.out.println(instant_2020_2_1.truncatedTo(ChronoUnit.HOURS));
    System.out.println(instant_2020_2_1.truncatedTo(ChronoUnit.DAYS));
  }

}
