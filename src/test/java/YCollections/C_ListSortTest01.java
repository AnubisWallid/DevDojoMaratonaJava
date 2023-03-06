package YCollections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_ListSortTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(3);
        nomes.add("Clau");
        nomes.add("Feeh");
        nomes.add("Hellen");
        nomes.add("Gio");
        nomes.add("Bia");
        nomes.add("Ana");
        nomes.add("Dani");
        for (String s:nomes){
            System.out.println(s);
        }
        Collections.sort(nomes);
        System.out.println("Depois do Collections.sort(nomes): ");

        for (String s:nomes){
            System.out.println(s);
        }
    }
}
