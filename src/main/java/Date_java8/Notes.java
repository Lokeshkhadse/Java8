package Date_java8;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Notes {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1998, 12, 5);

        long daysBetween = ChronoUnit.DAYS.between(birthDate, today);
        long monthsBetween = ChronoUnit.MONTHS.between(birthDate, today);
        long yearsBetween = ChronoUnit.YEARS.between(birthDate, today);
        System.out.println("Days between: " + daysBetween);
        System.out.println("Months between: " + monthsBetween);
        System.out.println("Years between: " + yearsBetween);

        int year = 2024;
        System.out.println("Is " + year + " a leap year? " + Year.isLeap(year));

    }





}
