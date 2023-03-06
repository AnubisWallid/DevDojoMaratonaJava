package RDatas;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate localdate01 = LocalDate.now();
        LocalDate localdate02 = LocalDate.of(1993,10,29);
        Period periodo = Period.between(localdate01,localdate02);
        Period periodo2 = Period.ofWeeks(40);
        System.out.println(periodo);
        System.out.println(localdate02.until(localdate02.plusDays(periodo2.getDays()), ChronoUnit.MONTHS));
    }
}
