package Date_java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Java8DateTimeExamples {

    public static void main(String[] args) {

        // ---------------------------------------------
        // 🔹 1. LocalDate – Working with Dates
        // ---------------------------------------------
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate specificDate = LocalDate.of(2025, 1, 1);
        System.out.println("Specific Date: " + specificDate);

        LocalDate parsedDate = LocalDate.parse("2025-03-15");
        System.out.println("Parsed Date: " + parsedDate);

        // ---------------------------------------------
        // 🔹 2. LocalTime – Working with Time
        // ---------------------------------------------
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime specificTime = LocalTime.of(10, 30);
        System.out.println("Specific Time: " + specificTime);

        LocalTime parsedTime = LocalTime.parse("15:45");
        System.out.println("Parsed Time: " + parsedTime);

        // ---------------------------------------------
        // 🔹 3. LocalDateTime – Date + Time
        // ---------------------------------------------
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + dateTime);

        LocalDateTime dt = LocalDateTime.of(2025, 7, 22, 10, 20,15);
        System.out.println("Specific DateTime: " + dt);

        // ---------------------------------------------
        // 🔹 4. Formatting & Parsing Dates
        // ---------------------------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatted = today.format(formatter);
        System.out.println("Formatted Date: " + formatted);

        LocalDate parsedFormattedDate = LocalDate.parse("22-07-2025", formatter);
        System.out.println("Parsed from formatted: " + parsedFormattedDate);

        // ---------------------------------------------
        // 🔹 5. Date Arithmetic – Add/Subtract
        // ---------------------------------------------
        System.out.println("5 Days Later: " + today.plusDays(5));
        System.out.println("2 Weeks Later: " + today.plusWeeks(2));
        System.out.println("3 Months Later: " + today.plusMonths(3));
        System.out.println("1 year Later :  " + today.plusYears(1));
        System.out.println("1 year ago :  " + today.minusYears(1));
        System.out.println("3 Months ago: " + today.minusMonths(3));
        System.out.println("2 weeks ago: " + today.minusWeeks(3));
        System.out.println("3 Days ago: " + today.minusDays(3));


        // ---------------------------------------------
        // 🔹 6. Period – Date Difference (NOT use LocalTime OR LocalDateTime) USE LocalDate
        // ---------------------------------------------
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2025, 7, 22);

        Period diff = Period.between(start, end);
        System.out.println("Period Between Dates: " + diff);
        System.out.println("Years: " + diff.getYears() + ", Months: " + diff.getMonths() + ", Days: " + diff.getDays());

        // ---------------------------------------------
        // 🔹 7. Duration – Time Difference  (not use LocalDate) USE LocalTime or LocalDateTime
        // ---------------------------------------------
        LocalTime t1 = LocalTime.of(10, 30);
        LocalTime t2 = LocalTime.of(12, 45);

        Duration duration = Duration.between(t1, t2);
        System.out.println("Duration (hrs): " + duration.toHours());
        System.out.println("Duration (mins): " + duration.toMinutes());

        // ---------------------------------------------
        // 🔹 8. Compare Dates and Times
        // ---------------------------------------------
        LocalDate d1 = LocalDate.of(2025, 1, 1);
        LocalDate d2 = LocalDate.of(2025, 7, 22);

        System.out.println("Is d1 before d2? " + d1.isBefore(d2));
        System.out.println("Is d2 after d1? " + d2.isAfter(d1));
        System.out.println("Are dates equal? " + d1.equals(d2));

        // ---------------------------------------------
        // 🔹 9. Get Day, Month, Year from Date
        // ---------------------------------------------
        System.out.println("Day: " + today.getDayOfMonth());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Year: " + today.getYear());
        System.out.println("Day of Week: " + today.getDayOfWeek());

        // ---------------------------------------------
        // 🔹 10. Working with Time Zones
        // ---------------------------------------------
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + zdt);

        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York Time: " + nyTime);

        // ---------------------------------------------
        // 🔹 11. Convert LocalDateTime to ZonedDateTime
        // ---------------------------------------------
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zoned = ldt.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("Zoned DateTime: " + zoned);

        // ---------------------------------------------
        // 🔹 12. Convert ZonedDateTime to another time zone
        // ---------------------------------------------
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime usaTime = indiaTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("India Time: " + indiaTime);
        System.out.println("USA Time: " + usaTime);

        // ---------------------------------------------
        // 🔹 13. Truncate to Hours
        // ---------------------------------------------
        LocalDateTime nowDT = LocalDateTime.now();
        System.out.println("Truncated to Hour: " + nowDT.truncatedTo(ChronoUnit.HOURS));

        // ---------------------------------------------
        // 🔹 14. First Day of Month/Year
        // ---------------------------------------------
        System.out.println("First day of month: " + today.withDayOfMonth(1));
        System.out.println("First day of year: " + today.withDayOfYear(1));

        // ---------------------------------------------
        // 🔹 15. Check Leap Year
        // ---------------------------------------------
        LocalDate leapYear = LocalDate.of(2024, 1, 1);
        System.out.println("Is leap year? " + leapYear.isLeapYear());
    }
}
