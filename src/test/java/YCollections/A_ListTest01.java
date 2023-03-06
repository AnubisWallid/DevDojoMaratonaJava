package YCollections;

import java.util.ArrayList;
import java.util.List;

public class A_ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(3); //1.4 depois
        List<String> nomes2 = new ArrayList<>(3);
        nomes.add("Ana");
        nomes.add("Bia");
        nomes.add("Clau");
        nomes2.add("Feeh");
        nomes2.add("Gio");
        nomes2.add("Hellen");
        System.out.println("Tamanho: "+ nomes.size());
        nomes.add("Denis");
        System.out.println("Ana: posição " + nomes.indexOf("Ana"));
        System.out.println("Tamanho: "+ nomes.size());
        System.out.println("Nomes 1: " + nomes);
        nomes.remove("Bia");
        System.out.println("Nomes 1: " + nomes);
        System.out.println("Nomes 2: " + nomes2);
        nomes.addAll(nomes2);
        System.out.println("Nomes 1: " + nomes);
        System.out.println("Nomes 2: " + nomes2);
    }
}
