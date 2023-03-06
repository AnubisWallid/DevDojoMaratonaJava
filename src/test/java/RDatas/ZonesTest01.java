package RDatas;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZonesTest01 {
    private static LocalDate localDate1;

    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
            System.out.println(shortIds);
            System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
            System.out.println(tokyoZone);
        LocalDateTime agora = LocalDateTime.now();
            System.out.println(agora);
        ZonedDateTime localDateTimeTokyo = agora.atZone(tokyoZone);
            System.out.println(localDateTimeTokyo);

        Instant nowInstant = Instant.now();
            System.out.println(nowInstant);
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
            System.out.println(zonedDateTime2);

            System.out.println(ZoneOffset.MIN);
            System.out.println(ZoneOffset.MAX);
        ZoneOffset offSetManaus = ZoneOffset.of("-04:00");

        OffsetDateTime offsetDateTime1 = agora.atOffset(offSetManaus);
            System.out.println(offsetDateTime1);
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(agora, offSetManaus);
            System.out.println(offsetDateTime2);
        OffsetDateTime offsetDateTime3 = nowInstant.atOffset(offSetManaus);
            System.out.println(offsetDateTime3);

            setData(01,01,1900);
            setData(01,01,1910);
            setData(01,01,2000);
            setData(01,01,2020);
    }
    public static void setData(int dia,int mes,int ano) {
     LocalDate localDate = LocalDate.of(ano, mes, dia);
        JapaneseDate era = JapaneseDate.from(localDate);
        System.out.printf("%d/%d/%d, %s\n",dia,mes,ano,era);
    }
}
