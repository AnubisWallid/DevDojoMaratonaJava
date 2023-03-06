package RDatas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime0 = LocalDateTime.now();
        LocalDate data01 = LocalDate.of(2000,01,01);
        LocalDate data02 = LocalDate.parse("2001-12-31");
        LocalTime tempo01 = LocalTime.of(15,25);
        System.out.println(localDateTime0);
        LocalDateTime localDateTime1 = data01.atTime(tempo01);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = tempo01.atDate(data02);
        System.out.println(localDateTime2);
    }

}
