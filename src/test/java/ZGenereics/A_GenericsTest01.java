package ZGenereics;

import java.util.ArrayList;
import java.util.List;

public class A_GenericsTest01 {
    public static void main(String[] args) {
//        List lista = new ArrayList<>(); // Antes do Generics < >
        List<String> lista = new ArrayList<>();
        lista.add("A");
//        lista.add(12);
//        lista.add(14.00);
        lista.add("B");
        for (Object o : lista) {
            if (o instanceof String) {
                System.out.println("String: " + o);
            }
            if (o instanceof Integer) {
                System.out.println("Inteiro: " + o);
            }
            if (o instanceof Double) {
                System.out.println("Double: " + o);
            }
        }
    }
}
