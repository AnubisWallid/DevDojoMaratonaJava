package SFormatacao;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        // ISO 639, ISO 3166 -> pt-BR (Brasil) it-IT (Italia)
        Locale localeItaly = new Locale("it","IT");
        Locale localeBrazil = new Locale("pt","BR");
        Locale localeSuice = new Locale("it","CH");
        Locale localeindia = new Locale("hi","IN");
        Locale localeJapan = new Locale("ja","JP");

        Calendar calendar = Calendar.getInstance();

        DateFormat dtIt = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat dtBr = DateFormat.getDateInstance(DateFormat.FULL, localeBrazil);
        DateFormat dtSu = DateFormat.getDateInstance(DateFormat.FULL, localeSuice);
        DateFormat dtIn = DateFormat.getDateInstance(DateFormat.FULL, localeindia);
        DateFormat dtJa = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);

        System.out.println(localeItaly.getDisplayCountry(localeItaly)+ ": " + dtIt.format(calendar.getTime()));// Italia sabato 14 gennaio 2023
        System.out.println(localeBrazil.getDisplayCountry()+ ": " + dtBr.format(calendar.getTime()));// Brasil sábado, 14 de janeiro de 2023
        System.out.println(localeSuice.getDisplayCountry()+ ": " + dtSu.format(calendar.getTime()));// Suiça sabato, 14 gennaio 2023
        System.out.println(localeindia.getDisplayCountry()+ ": " + dtIn.format(calendar.getTime()));// India शनिवार, 14 जनवरी 2023
        System.out.println(localeJapan.getDisplayCountry()+ ": " + dtJa.format(calendar.getTime()));// Japão 2023年1月14日土曜日
    }
}
