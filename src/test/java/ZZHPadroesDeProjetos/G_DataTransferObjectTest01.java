package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.*;

public class G_DataTransferObjectTest01 {
    public static void main(String[] args) {
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder
                .builder()
                .firstName("Walllid").
                build();
        ReportDTO reportDTO = ReportDTO.ReportDTOBuilder
                .builder()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getFirstName()).build();
        System.out.println(reportDTO);
    }
}
