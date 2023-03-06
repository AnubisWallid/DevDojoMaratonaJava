package SFormatacao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String mask = "dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mask);
        Calendar data = Calendar.getInstance();
        System.out.println(simpleDateFormat.format(data.getTime()));
    }
}
