package SFormatacao;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {
        Locale localeItaly = new Locale("it","IT");
        Locale localeBrazil = new Locale("pt","BR");
        Locale localeSuice = new Locale("it","CH");
        Locale localeindia = new Locale("hi","IN");
        Locale localeJapan = new Locale("ja","JP");
        NumberFormat[] numberFormat = new NumberFormat[4];
        numberFormat[1] = NumberFormat.getCurrencyInstance(localeItaly);
        numberFormat[3] = NumberFormat.getCurrencyInstance(localeSuice);
        numberFormat[0] = NumberFormat.getCurrencyInstance(localeindia);
        numberFormat[2] = NumberFormat.getCurrencyInstance(localeJapan);
        double valor = 12_000.2546;
        for(NumberFormat nf : numberFormat){
            System.out.println(nf.format(valor));
        }

    }
}
