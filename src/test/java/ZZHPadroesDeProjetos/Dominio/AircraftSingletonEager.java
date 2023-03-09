package ZZHPadroesDeProjetos.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonEager {
    //Eager initialization -
    //Rapido -> private static final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("787-A");
    private static final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("787-A");
    private final String name;
    private final Set<String> availableSeats = new HashSet<>();

    private AircraftSingletonEager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static AircraftSingletonEager getINSTANCE(){
        return INSTANCE;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }
    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
