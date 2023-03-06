package YCollections;

import YCollections.dominio.Smartphone;

import java.util.HashSet;
import java.util.Set;

public class H_SetTest01 {
    public static void main(String[] args) {
        Set<Smartphone> smartphones = new HashSet<>(); //Não permite elementos duplicados, e não tem ordem

        smartphones.add(new Smartphone("01", "AAA", 30.0,10));
        smartphones.add(new Smartphone("06", "EEE", 40.0,0));
        smartphones.add(new Smartphone("03", "BBB", 20.0,15));
        smartphones.add(new Smartphone("04", "CCC", 10.0,0));
        smartphones.add(new Smartphone("05", "DDD", 60.0,2));
        smartphones.add(new Smartphone("02", "FFF", 0.0,0));

        for(Smartphone s : smartphones){
            System.out.println(s);
        }
    }
}
