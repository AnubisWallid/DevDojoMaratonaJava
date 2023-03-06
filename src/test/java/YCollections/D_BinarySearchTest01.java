package YCollections;

import YCollections.dominio.Smartphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D_BinarySearchTest01 {
    public static void main(String[] args) {
        CelularByPrice celularByPrice = new CelularByPrice();
        List<Smartphone> numeros1 = new ArrayList<>(4);
        numeros1.add(new Smartphone("03", "BBB", 20.0));
        numeros1.add(new Smartphone("01", "AAA", 30.0));
        numeros1.add(new Smartphone("04", "CCC", 10.0));
        numeros1.add(new Smartphone("06", "EEE", 40.0));
        numeros1.add(new Smartphone("05", "DDD", 60.0));
        Smartphone celular1 = new Smartphone("02", "DDD", 30.12);

        Collections.sort(numeros1);
        for (Smartphone s: numeros1){
            System.out.println(s);
        }

        System.out.println("Indice: "+Collections.binarySearch(numeros1,celular1));
        numeros1.sort(celularByPrice);
        for (Smartphone s: numeros1){
            System.out.println(s);
        }

        System.out.println("Indice: "+Collections.binarySearch(numeros1,celular1,celularByPrice));
//        Collections.binarySearch();
    }
}
