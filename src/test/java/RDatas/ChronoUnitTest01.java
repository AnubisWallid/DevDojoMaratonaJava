package RDatas;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(1993, Month.OCTOBER, 29, 21, 30);
        System.out.println(ChronoUnit.DAYS.between(aniversario, LocalDateTime.now()) + " Dias");
        System.out.println(ChronoUnit.WEEKS.between(aniversario, LocalDateTime.now()) + " Semanas");
        System.out.println(ChronoUnit.MONTHS.between(aniversario, LocalDateTime.now()) + " Meses");
        System.out.println(ChronoUnit.YEARS.between(aniversario, LocalDateTime.now()) + " Anos");
    }
}
