package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.AircraftSingletonLazy;

import java.lang.reflect.InvocationTargetException;

public class E_AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        /*Criando nova instancia... burlando...*/
        /*System.out.println(AircraftSingletonLazy.getINSTANCE());
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("123456");
        System.out.println(aircraftSingletonLazy);*/
    }
    private static void bookSeat(String seat){
        AircraftSingletonLazy aircraft = AircraftSingletonLazy.getINSTANCE();
        System.out.printf("%s: %b%n",aircraft.getName(),aircraft.bookSeat(seat));
    }
}
