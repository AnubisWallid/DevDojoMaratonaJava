package ZZHPadroesDeProjetos.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final String name;
    private final Set<String> availableSeats = new HashSet<>();

    public Aircraft(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }
    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
