package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.Country;
import ZZHPadroesDeProjetos.Dominio.Currency;
import ZZHPadroesDeProjetos.Dominio.CurrencyFactory;

public class B_CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
