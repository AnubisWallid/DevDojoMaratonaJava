package YCollections;

import YCollections.dominio.Smartphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C_ListSortTest02 {
    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone("03", "Samsung", 20.12);
        Smartphone smartphone2 = new Smartphone("01", "Xiaomi", 15.52);
        Smartphone smartphone3 = new Smartphone("02", "IPhone", 25.27);
        Smartphone smartphone4 = new Smartphone("02", "Amazon", 10.98);

        List<Smartphone> celulares = new ArrayList<>(10);
        celulares.add(smartphone1);
        celulares.add(smartphone2);
        celulares.add(smartphone3);
        celulares.add(smartphone4);

        for (Smartphone s : celulares) {
            System.out.println("ID: " + s.getId() + ", Marca: " + s.getMarca() + "Preço: " + s.getPreco());
        }
//        Comparator<Smartphone> comparatorCelulares = (o1, o2) -> o1.getId().compareTo(o2.getId());
        Comparator<Smartphone> comparatorCelulares = Comparator.comparing(Smartphone::getId);
//        celulares.sort(comparatorCelulares);
        Collections.sort(celulares);
        System.out.println("Depois do Collections.sort(celulares);");
        for (Smartphone s : celulares) {
            System.out.println("ID: " + s.getId() + ", Marca: " + s.getMarca() + "Preço: " + s.getPreco());
        }
        Collections.sort(celulares, new CelularByPrice());
        System.out.println("Depois do Collections.sort(celulares,new CelularByPrice());");
        for (Smartphone s : celulares) {
            System.out.println("Preço: " + s.getPreco() + ", Marca: " + s.getMarca() + ", ID: " + s.getId());
        }

    }
}
