package YCollections;

import YCollections.dominio.Consumidor;
import YCollections.dominio.Smartphone;

import java.util.*;

public class N_MapTest03 {
    public static void main(String[] args) {
//        Set<Smartphone> smartphones = new HashSet<>(); //Não permite elementos duplicados, e não tem ordem
        Smartphone s1 = new Smartphone("01", "AAA", 30.0, 10);
        Smartphone s2 = new Smartphone("06", "EEE", 40.0, 0);
        Smartphone s3 = new Smartphone("03", "BBB", 20.0, 15);
        Smartphone s4 = new Smartphone("04", "CCC", 10.0, 0);
        Smartphone s5 = new Smartphone("05", "DDD", 60.0, 2);
        Smartphone s6 = new Smartphone("02", "FFF", 0.0, 0);

        Consumidor cons1 = new Consumidor("Rodrigo");
        Consumidor cons2 = new Consumidor("Carlos");


        Map<Consumidor, List<Smartphone>> map = new LinkedHashMap<>();
        map.put(cons1, List.of(s1, s2, s3));
        map.put(cons2, List.of(s4, s5, s6));

        for (Map.Entry<Consumidor, List<Smartphone>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": ");
            for (Smartphone s : entry.getValue()) {
                System.out.println("   " + s.getMarca());
            }
            System.out.println("-----------------------");
        }

    }
}
