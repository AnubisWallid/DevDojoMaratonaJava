package RDatas;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());
        LocalDate data = LocalDate.of(1993, Month.NOVEMBER,29);
        System.out.println(data.getEra());
        System.out.println(data.getDayOfWeek());
        System.out.println(data.isLeapYear());
    }
}
