package ZZHPadroesDeProjetos.Dominio;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSingletonEnum {
    INSTANCE,NAME("777");

    private final Set<String> availableSeats;

    AircraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }
    AircraftSingletonEnum(String s){
        this();
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
