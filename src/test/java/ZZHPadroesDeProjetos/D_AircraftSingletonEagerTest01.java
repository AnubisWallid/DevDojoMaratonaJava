package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.AircraftSingletonEager;

public class D_AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat){
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.printf("%s: %b%n",aircraft.getName(),aircraft.bookSeat(seat));
    }
}
