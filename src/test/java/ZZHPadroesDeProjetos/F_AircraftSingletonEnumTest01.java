package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.AircraftSingletonEnum;

public class F_AircraftSingletonEnumTest01 {
    public static void main(String[] args){
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat){
        AircraftSingletonEnum aircraft = AircraftSingletonEnum.INSTANCE;
        System.out.printf("%s: %b%n",aircraft.NAME,aircraft.bookSeat(seat));
    }
}
