package YCollections;

import YCollections.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        String nome1 = "Wallid Santana";
        String nome2 = new String("Wallid Santana");

        System.out.println(nome1 == nome2);
        System.out.println(nome1.equals(nome2));

        Smartphone smartphone1 = new Smartphone("102125", "Samsung",10.00);
        Smartphone smartphone2 = new Smartphone("102125", "Samsung",15.74);
        System.out.println("Celulares iguais ? " + smartphone1.equals(smartphone2));

    }
}
