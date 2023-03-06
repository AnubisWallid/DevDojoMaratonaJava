package SFormatacao;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();

        for (String iso: isoLanguages) {
            System.out.print(iso + ", ");
        }
        System.out.println();
        for (String iso: isoCountries) {
            System.out.print(iso + ", ");
        }

    }
}
