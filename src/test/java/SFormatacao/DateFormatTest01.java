package SFormatacao;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] df = new DateFormat[7];

        df[0] = DateFormat.getInstance();// 14/01/2023 00:23
        df[1] = DateFormat.getDateInstance();// 14 de jan. de 2023
        df[2] = DateFormat.getDateTimeInstance();// 14 de jan. de 2023 00:23:04
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT);// 14/01/2023
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);// 14 de jan. de 2023
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);// 14 de janeiro de 2023
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);// sábado, 14 de janeiro de 2023

        for (DateFormat dft: df) {
            System.out.println(dft.format(calendar.getTime()));
        }
    }
}
