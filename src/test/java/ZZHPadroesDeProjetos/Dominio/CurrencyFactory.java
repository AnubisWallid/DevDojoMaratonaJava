package ZZHPadroesDeProjetos.Dominio;

public class CurrencyFactory {
    public static Currency newCurrency(Country country){
        return switch (country) {
            case UNITED_STATE -> new UsDollar();
            case BRAZIL -> new Real();
        };
    }
}
