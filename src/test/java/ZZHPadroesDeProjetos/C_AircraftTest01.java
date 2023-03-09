package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.Aircraft;

public class C_AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat){
        Aircraft aircraft = new Aircraft("767");
        System.out.printf("%s: %b%n",aircraft.getName(),aircraft.bookSeat(seat));
    }
}
