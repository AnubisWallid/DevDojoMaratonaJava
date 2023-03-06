package YCollections;

import YCollections.dominio.Consumidor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class M_MapTest02 {
    public static void main(String[] args) {
        Consumidor cons1 = new Consumidor("Rodrigo");
        Consumidor cons2 = new Consumidor("Carlos");
        Consumidor cons3 = new Consumidor("Maria");
        Consumidor cons4 = new Consumidor("joao");

        Map<Consumidor, String> map = new LinkedHashMap<>();
        map.put(cons1,cons1.getNome());
        map.put(cons2,cons2.getNome());
        map.put(cons3,cons3.getNome());
        map.put(cons4,cons4.getNome());
        System.out.println("-----------------------");
        for(Map.Entry<Consumidor,String> n: map.entrySet()){
            System.out.println(n.getKey().getId() +" : "+n.getValue());
        }
    }
}
