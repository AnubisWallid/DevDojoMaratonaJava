package SFormatacao;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {
        Locale localeItaly = new Locale("it","IT");
        Locale localeBrazil = new Locale("pt","BR");
        Locale localeSuice = new Locale("it","CH");
        Locale localeindia = new Locale("hi","IN");
        Locale localeJapan = new Locale("ja","JP");
        NumberFormat[] numberFormat = new NumberFormat[4];
        numberFormat[0] = NumberFormat.getInstance(localeindia);
        numberFormat[1] = NumberFormat.getInstance(localeItaly);
        numberFormat[2] = NumberFormat.getInstance(localeJapan);
        numberFormat[3] = NumberFormat.getInstance(localeSuice);
        double valor = 12_000.2546;
        for(NumberFormat nf : numberFormat){
            System.out.println(nf.format(valor));
        }

    }
}
