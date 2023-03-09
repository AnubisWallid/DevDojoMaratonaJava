package ZZHPadroesDeProjetos.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    //Lazy initialization
    //Rapido ->
    private static AircraftSingletonLazy INSTANCE;
    private final String name;
    private final Set<String> availableSeats = new HashSet<>();

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static /*synchronized*/ AircraftSingletonLazy getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("999-100");
                }
            }
        }
        return INSTANCE;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
