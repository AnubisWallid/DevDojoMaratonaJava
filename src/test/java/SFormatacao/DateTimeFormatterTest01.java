package SFormatacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String format1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format2 = date.format(DateTimeFormatter.ISO_DATE);
        String format3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);

        LocalDate parse1 = LocalDate.parse("1993-10-29");
        System.out.println(parse1);
        LocalDate parse2 = LocalDate.parse("20230116",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse2);
        LocalDate parse3 = LocalDate.parse("2023-01-16",DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse3);

        LocalDateTime now = LocalDateTime.now();
        String format4 = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(format4);
        LocalDateTime parse4 = LocalDateTime.parse("2023-01-16T23:58:51.0399893", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(parse4);

        DateTimeFormatter dateTimeFormatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatterUSA = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatBR = date.format(dateTimeFormatterBR);
        String formatUSA = date.format(dateTimeFormatterUSA);
        System.out.println(formatBR);
        System.out.println(formatUSA);

        LocalDate parseBR = LocalDate.parse("29/10/1993", dateTimeFormatterBR);
        LocalDate parseUSA = LocalDate.parse("10/29/1993", dateTimeFormatterUSA);
        System.out.println(parseBR);
        System.out.println(parseUSA);

    }
}
