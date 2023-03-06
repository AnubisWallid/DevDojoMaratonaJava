package YCollections;

import YCollections.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class B_SmartphoneTest01 {
    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone("102125", "Samsung");
        Smartphone smartphone2 = new Smartphone("1165225", "Xiaomi");
        Smartphone smartphone3 = new Smartphone("1023125", "IPhone");
        Smartphone smartphone4 = new Smartphone("12342125", "WindowsPhone");
        Smartphone smartphone5 = new Smartphone("1162125", "Pixel");
        List<Smartphone> celulares = new ArrayList<>(10);
        celulares.add(smartphone1);
        celulares.add(smartphone2);
        celulares.add(smartphone3);
        celulares.add(0, smartphone4);
        System.out.println(celulares);
        System.out.println("List.indexOf(smartphone5): " + celulares.indexOf(smartphone5) + " // List.contains(smartphone5): " + celulares.contains(smartphone5));
        System.out.println("List.get(3): " + celulares.get(3));

    }
}
